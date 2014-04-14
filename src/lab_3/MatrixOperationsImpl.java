package lab_3;

/**
 * This class implements the IMatrixOperations interface. It calculates the 
 * determinant of a Matrix and the minor.
 */
public class MatrixOperationsImpl implements IMatrixOperations {
    
    /**
     * Default constructor of this class.
     */
    public MatrixOperationsImpl()
    {
    }
    
    /**
     * This method calculates the determinant of the matrix using the Laplace
     * transformation. It first verifies that the matrix is squared. If not
     * it will throw a RuntimeException. 
     * 
     * If the matrix is valid it then checks if the matrix is of size 1 it
     * returns the 0,0 element values, if the matrix is of size 2 it multiplies
     * the diagonals.
     * 
     * If is the matrix is greater than 2 it then uses the Laplace 
     * transformation using the following formula:
     * 
     * det(matrix) = Sumi power(-1, i + j) * a[i,j] * det(minor(a[i,j])) for
     * i = 1
     * 
     * @param matrix Matrix to calculate the determinant
     * @return Returns the determinant of the matrix
     */
    @Override
    public double determinant(IMatrix matrix)
    {
        if(!matrix.isSquared())
        {
            throw new RuntimeException("Marix is not squared");
        }
        // When size = 1 the determinant is just the matrix element
        if (matrix.size() == 1) 
        {
            return matrix.getValue(0, 0);
	}
        
        // Size of two is the product of it's diagonals
        if (matrix.size() == 2) 
        {
            return (matrix.getValue(0, 0) * matrix.getValue(1, 1)) - 
                    ( matrix.getValue(0, 1) * matrix.getValue(1, 0));
	}
        
        double determinantSumation = 0.0;
        // For each of the columns and choosing a row of 1 it calculates
        // recursively the determinant.
        for (int j = 0; j < matrix.getNumberOfColumns(); j++) 
        {
            determinantSumation += 
                    Math.pow(-1, (1 + j)) * matrix.getValue(1, j) * 
                    determinant(minor(matrix, 1, j));
	}
        
        return determinantSumation;
    }
    
    /**
     * This method returns the minor of a matrix. The minor extracts out the
     * row/column specified in the arguments
     * @param matrix Matrix to perform the minor 
     * @param rowToExclude Row to exclude
     * @param columnToExclude Column to exclude
     * @return Returns a new matrix that have excluded the row and column 
     * values
     */
    @Override
    public IMatrix minor(IMatrix matrix, 
                         int rowToExclude, 
                         int columnToExclude)
    {
        // Creates a new matrix with one less row/column
        IMatrix minorMatrix = 
                MatrixFactory.createArrayMatrix(matrix.getNumberOfRows() - 1, 
                           matrix.getNumberOfColumns() - 1);
        
        int row = -1;
        // Loops through each row and excludes the one specified
        for (int currentRow = 0; currentRow < matrix.getNumberOfRows(); 
                currentRow++) 
        {
            if (currentRow == rowToExclude) {
                continue;
            }
            
            row++;
            
            int column = -1;
            // Loops through each column excluding the one specified as
            // arguments
            for (int currentColumn = 0; 
                    currentColumn < matrix.getNumberOfColumns(); 
                    currentColumn++) 
            {
                if (currentColumn == columnToExclude) 
                {
                    continue;
                }
                
                minorMatrix.setValue(row, 
                             ++column, 
                             matrix.getValue(currentRow, currentColumn));
            }
        }
        
        return minorMatrix;
    }
}
