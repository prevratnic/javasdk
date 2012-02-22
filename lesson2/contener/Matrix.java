package lesson2.contener;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 22.02.12
 * Time: 0:13
 */

public class Matrix {
    
    private int matrix[][];
    private int m;
    private int n;

    public Matrix( int m, int n ){
        this.m = m;
        this.n = n;

        this.matrix = new int[ m ][ n ];
    }
    
    public void addItem( int item ){
        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                matrix[i][j] = item;
            }
        }
    }

    public void output(){
        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

}
