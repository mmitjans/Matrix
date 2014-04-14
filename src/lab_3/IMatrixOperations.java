package lab_3;

/**
 * This interface performs matrix operations such as to calculate the
 * determinant and minor.
 * 
 */
public interface IMatrixOperations {
    
    /**
     * This method calculates the determinant of a matrix.
     * @param matrix matrix to calculate the determinant
     * @return the determinant of the matrix
     */
    public double determinant(IMatrix matrix);
    
    /**
     * This method returns new matrix formed by deleting the row and column
     * of the specified matrix
     * @param matrix Matrix to perform the minor operation
     * @param row Row to delete
     * @param column Column to delete
     * @return A new matrix with the deleted row/column
     */
    public IMatrix minor(IMatrix matrix, int row, int column);
}
