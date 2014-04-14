/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_3;

/**
 *
 * @author miltondmitjans
 */
public class MatrixFactory {
    
    public static IMatrix createArrayMatrix(int rows, int columns)
    {
        return new MatrixArrayImpl(rows, columns);
    }
    
    public static IMatrix createLinkedMatrix(int rows, int columns)
    {
        return new MatrixLinkedImpl(rows, columns);
    }
}
