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

    private int i;
    private int j;

    public Matrix( int m, int n ){
        this.m = m;
        this.n = n;

        this.matrix = new int[ m ][ n ];
    }
    
    public void addItem( int item, int m, int n ){
        matrix[m][n] = item;
    }

    public void addItem( int item ){
        if( j < n ){
            matrix[i][j] = item;
            j++;
        }
        if( j == n ){
            j = 0;
            i++;
        }
    }

    public Matrix add( Matrix sumMatrix ) throws Exception {

        Matrix result = null;

        if( (m == sumMatrix.m) && (n == sumMatrix.n) ){
            result = new Matrix( m, n );

            for( int i = 0; i < m; i++ ){
                for( int j = 0; j < n; j++ ){
                    result.addItem( (this.matrix[i][j]) + (sumMatrix.matrix[i][j]) );
                }
            }

        }else {
            throw new Exception("Error matrix size ");
        }

        return result;
    }

    public boolean equal( Matrix eqMatrix ){

        boolean flag = false;

        if( (m != eqMatrix.m) || (n != eqMatrix.n) ) return false;

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                flag = this.matrix[i][j] == eqMatrix.matrix[i][j];
                if( flag == false ) return false;
            }
        }

        return flag;
    }

    public void output(){
        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                System.out.print( matrix[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

}
