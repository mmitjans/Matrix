package lab_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * This class reads the matrix content in a Queue of Strings and creates
 * an Matrix object that represents the matrix.
 * 
 * The Queue must me represented as:
 * 3 (size of the matrix)
 * 1 2 3 (row, column)
 * 4 5 6
 * 7 8 9
 * 
 * The elements of the matrix must contain a delimiter which is passed to the
 * constructor of the class.
 * 
 */
public class MatrixGenerator {
    
    // Maximum size of the matrix
    private int _maxSize = 0;
    // Delimiter of the String that contains the element values
    private String _delimiter;
    
    // List of Matrix objects
    private List<IMatrix> _matrices = new LinkedList<IMatrix>();
    
    /**
     * Default constructor of this class. Creates a List of Matrix objects
     * using the input list, determined by the maximum size that a Matrix
     * can be and the delimiter use to separate the element values.
     * @param inputList List of Strings that contains the information about the
     * matrix
     * @param maxSize Maximum size of the matrix
     * @param delimiter Delimiter use to separate the matrix element values.
     */
    public MatrixGenerator(Queue<String> inputList, 
                           int maxSize,
                           String delimiter)
    {
        _maxSize = maxSize;
        _delimiter = delimiter;
        
        // For each matrix data it process it's values
        // For example it will go to the next line where the
        // matrix size is set
        while(inputList.size() > 0)
            processMatrix(inputList);
    }
        
    public List<IMatrix> getMatrixes()
    {
        return this._matrices;
    }
    
    /**
     * This method reads from the Queue of String's the matrix information.
     * It first remove's the first element which contains the matrix size. It
     * then pop's from the Queue the element values of the matrix.
     * 
     * If the Queue contains less/more values than expected it will throw
     * a RuntimeException
     * @param inputList List of strings that contains the matrix information
     */
    private void processMatrix(Queue<String> inputList)
    {
        // Removes the element that contains the size of the matrix
        String matrixSize = inputList.remove();
        int sizeOfMatrix = Integer.parseInt(matrixSize);
        
        // Makes sure that the matrix is of the correct size
        if(sizeOfMatrix < 0 && sizeOfMatrix > _maxSize)
        {
            throw new RuntimeException("Matrix size is invalid");
        }
        
        IMatrix matrix = 
                MatrixFactory.createLinkedMatrix(sizeOfMatrix, sizeOfMatrix);
        
        // Pop's from the queue is element to get the row of the matrix
        for(int rowIter = 0; rowIter < sizeOfMatrix; rowIter++)
        {
            String matrixContent = inputList.remove();
            
            StringTokenizer t = new StringTokenizer(matrixContent, _delimiter);
            
            // Counts the number of columns using the tokenizer with the
            // specified delimiter, if the number of tokens not equals the
            // size of the matrix it throw's a RuntimeException
            int numColumns = t.countTokens();
            if(numColumns == sizeOfMatrix)
            {
                // Now gets the column elements
                for(int columnIter = 0; columnIter < sizeOfMatrix; columnIter++)
                {
                    double value = Double.parseDouble(t.nextToken());
                    
                    matrix.setValue(rowIter, columnIter, value);
                }
            } else {
                throw new RuntimeException("Matrix element are not valid");
            }
        }
        
        this._matrices.add(matrix);
    }
    
}
