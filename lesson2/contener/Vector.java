package lesson2.contener;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 23.02.12
 * Time: 21:48
 */

public class Vector extends Matrix {

    public Vector( int m ) throws Exception {
        super( m, 1 );
    }

    public double length(){

        double result = 0;

        for( int i = 0; i < getM(); i++ ){
            for( int j = 0; j < getN(); j++ ){
                result += Math.pow( getIndex( i, j ), 2 );
            }
        }

        return Math.sqrt( result );
    }
}
