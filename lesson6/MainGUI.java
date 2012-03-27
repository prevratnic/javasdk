package lesson6;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 18:36
 */

public class MainGUI {

    public static void main(String[] args){
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DrawThread();
//            }
//        });

        Semaphore semaphore = new Semaphore(1);

        DataBase dataBase = new DataBase( semaphore );

        for( int i = 1; i < 5; i++ ){
            new Readers( i, dataBase, semaphore );
            new Writers( i, dataBase, semaphore );
        }

    }

}
