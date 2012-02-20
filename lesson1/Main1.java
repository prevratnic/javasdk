package lesson1;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 01.11.11
 * Time: 1:10
 */

import java.util.Scanner;

public class Main1 {

    public static void main( String[] args ){
        new Main1().sortNumber();
    }

    public void sortNumber(){

        Scanner scanner = new Scanner( System.in );

        int tmp;

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if( a > b ){
           tmp = a;
           a = b;
           b = tmp;
        }

        if( a > c ){
            tmp = a;
            a = c;
            c = tmp;
        }

        if ( b > c ) {
            tmp = b;
            b = c;
            c = tmp;
        }

        System.out.print( a + " " + b + " " + c );

    }

}
