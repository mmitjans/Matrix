/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_3;

import java.util.LinkedList;

/**
 *
 */
public class MatrixLinkedImpl implements IMatrix {
    
    // These variable contains the size of the row/columnt of the matrix
    private int numberOfColumns = 0;
    private int numberOfRows = 0;
    
    private DoublyHeaderList<Double> _data;
    
    /**
     * Default constructor of this class. It takes the number of rows and 
     * columns. It also creates the internal array that holds the element
     * values of the matrix.
     * @param numberOfColumns Number of columns
     * @param numberOfRows Number of rows
     */
    public MatrixLinkedImpl(int numberOfColumns, int numberOfRows)
    {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        _data = new DoublyHeaderList<>();       
    }
    
    /**
     * This methods sets an element value to the matrix at the specified
     * row and column. It will throw a RuntimeException when the row/column
     * are invalid
     * @param atRow Row index
     * @param atColumn Column index
     * @param value Double value to set in the matrix
     */
    @Override
    public void setValue(int atRow, int atColumn, double value)
    {
        // Checks if the element indexes are valid
        checkIfValid(atRow, atColumn);
        
        _data.addRight(value, atRow, atColumn);
        
    }
    
    /**
     * This method returns the element value specified by the row and column.
     * If the index of the row or column is invalid it will throw a 
     * RuntimeException
     * @param atRow
     * @param atColumn
     * @return 
     */
    @Override
    public double getValue(int atRow, int atColumn)
    {
        int index = convertMatrixIndex(atRow, atColumn);
        
        Double value = (Double)_data.getDataAtPosition(index);
        
        // Checks that the element indexes are valid
        checkIfValid(atRow, atColumn);
        // Returns the data
        return value;
    }
    
    /**
     * Helper method that prints the matrix content to the System Console.
     */
    public void print()
    {
        for(int row = 0; row < this.numberOfRows; row++)
        {
            for(int column = 0; column < this.numberOfColumns; column++)
            {
                System.out.print(getValue(row, column) + "\t");
            }
            
            System.out.println();
        }
    }
    
    /**
     * Returns a boolean indicating if the matrix is Squared (e.g 2x2, 3x3)
     * @return Returns true if the matrix is squared, otherwise false
     */
    @Override
    public boolean isSquared()
    {
        return ( this.numberOfRows == this.numberOfColumns);
    }
    
    /**
     * This method verifies if the indexes are valid. It will throw a 
     * RuntimeException is any of the elements are wrong.
     * @param row Row to validate
     * @param column Column to validate
     */
    private void checkIfValid(int row, int column)
    {
        if(row >= this.numberOfRows || column >= this.numberOfColumns)
        {
            throw new RuntimeException("Invalid row,column");
        }
    }
    
    private int convertMatrixIndex(int row, int column)
    {
        return ( this.numberOfRows * row ) + column;
    }
   
    /**
     * Returns the size of the matrix
     * @return Matrix size
     */
    @Override
    public int size()
    {
        return this.numberOfRows;
    }
    
    /**
     * Returns the number of Rows
     * @return Number of rows
     */
    @Override
    public int getNumberOfRows()
    {
        return this.numberOfRows;
    }
    
    /**
     * Returns the number of columns
     * @return Column number
     */
    @Override
    public int getNumberOfColumns()
    {
        return this.numberOfColumns;
    }
    
    /**
     * Returns a string representation of the matrix
     * @return String containing the matrix content
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                builder.append(getValue(row, column) + "\t");
            }

            builder.append("\n");
        }
        
        return builder.toString();
    }
}
