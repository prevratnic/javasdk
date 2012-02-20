package lesson1;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.11.11
 * Time: 22:06
 */

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        printMatrix();
    }

    public static void printMatrix(){

        Scanner in = new Scanner( System.in );

        System.out.print("Введите размер массива: ");

        int count = in.nextInt();

        int[][] arr = new int[count][count];

        for( int i = 0; i < arr.length; i++ ){
            for( int j = 0; j < i + 1; j++ ){
                System.out.print("Введите значение: ");
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                //System.out.print( "( i = " + i + ") (" + "j = " + j  + ") Values " + arr[i][j] + "\t" );
                System.out.print( arr[i][j] + "\t" );
            }
            System.out.print("\n");
        }

        System.out.print("\n" + "Наиболее близкое значение к 10: " +  valueTen( arr ) );

    }

    public static int valueTen( int[][] arr ){

        final int values = 10;

        int result = 0;

        for( int i = 0; i < arr.length; i++ ){
            for( int j = 0; j < arr.length; j++ ){
                if( arr[i][j] <= values ){
                    if( result < arr[i][j] ){
                        result = arr[i][j];
                    }
                }
            }
        }

        return result;
    }

}
