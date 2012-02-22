package lesson2;

import lesson2.contener.Matrix;

import java.util.Scanner;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 22.02.12
 * Time: 0:17
 */

public class Main1 {
    public static void main( String[] args ){

        System.out.println("Введите колличество строк матрицы :");

        Scanner scanner = new Scanner( System.in );
        int m = scanner.nextInt();

        System.out.println("Введите колличество столбцов матрицы :");

        int n = scanner.nextInt();

        Matrix matrix = new Matrix( m , n );
        matrix.addItem( 1 );
        matrix.addItem( 2 );
        matrix.addItem( 3 );
        matrix.addItem( 4 );
        matrix.addItem( 5 );
        matrix.addItem( 6 );
        matrix.addItem( 7 );

        matrix.output();

    }
}
