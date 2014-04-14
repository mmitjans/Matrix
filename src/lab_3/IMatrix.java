/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_3;

public interface IMatrix {
     /**
     * This methods sets an element value to the matrix at the specified
     * row and column. It will throw a RuntimeException when the row/column
     * are invalid
     * @param atRow Row index
     * @param atColumn Column index
     * @param value Double value to set in the matrix
     */
    public void setValue(int atRow, int atColumn, double value);
    
        /**
     * This method returns the element value specified by the row and column.
     * If the index of the row or column is invalid it will throw a 
     * RuntimeException
     * @param atRow
     * @param atColumn
     * @return 
     */
    public double getValue(int atRow, int atColumn);
    
    /**
     * Returns a boolean indicating if the matrix is Squared (e.g 2x2, 3x3)
     * @return Returns true if the matrix is squared, otherwise false
     */
    public boolean isSquared();

    /**
     * Returns the size of the matrix
     * @return Matrix size
     */
    public int size();
    
    /**
     * Returns the number of Rows
     * @return Number of rows
     */
    public int getNumberOfRows();
    
    /**
     * Returns the number of columns
     * @return Column number
     */
    public int getNumberOfColumns();
}
