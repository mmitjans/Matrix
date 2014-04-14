/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_3;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author miltondmitjans
 */
public class Lab_3 {
 // Maximum matrix size for this laboratory
    private static final int MATRIX_MAX_SIZE = 6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
             // Reads from the input file and generate a queue that contains a list
        // of string values that is on the input file
        FileProcessor fileIO = new FileProcessor(args[0], args[1]);
        Queue<String> values = fileIO.listOfStrings();
        
        // Creates the matrices
        MatrixGenerator matrixGenerator = 
                new MatrixGenerator(values, MATRIX_MAX_SIZE, " ");
        List<IMatrix> matrices = matrixGenerator.getMatrixes();
        
        // For each of the matrix is print's the content of the matrix
        // and calculates the determinant
        for(IMatrix matrix : matrices)
        {
            System.out.println();
            fileIO.printToFile("\n");
            fileIO.printToFile(matrix.toString());
            
            // Creates the IMatrixOperation implementation and uses this
            // object to calculate the determinant of the matrix
            IMatrixOperations matrixOperations = new MatrixOperationsImpl();
            double determinant = matrixOperations.determinant(matrix);
            
            fileIO.printToFile("Determinant result = " + determinant);
        }
        
        fileIO.closeWriter();
    }
    
}
