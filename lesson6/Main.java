package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 18:36
 */

public class Main {

    public static void main(String... args){

        DataBase dataBase = new DataBase();

        for( int i = 1; i < 10; i++ ){
            new Readers( dataBase, i );
            new Writers( dataBase, i );
        }
    }

}
