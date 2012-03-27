package lesson6;

import javax.swing.*;

import java.awt.*;

import static lesson6.DataBase.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 20:08
 */

public class Writers implements Runnable {

    private DataBase dataBase;
    private Semaphore semaphore;
    private int indexThread;

    public Writers(int indexThread, DataBase dataBase, Semaphore semaphore){

        this.indexThread = indexThread;
        this.semaphore = semaphore;
        this.dataBase = dataBase;

        Thread thread = new Thread( this, "Writers");
        thread.start();

    }

    @Override
    public void run() {
        for( int i = 0; i < 3; i++ ){

            System.err.println( "Writer " + indexThread + " is sleeping." );

            timeSleep();
            System.err.println( "Writer " + indexThread + " wants to write." );

            //semaphore.P();
                dataBase.startWrite();
            //semaphore.V();

            System.err.println( "               writer " + indexThread + " is writing." );

            timeSleep();
            System.err.println( "               writer " + indexThread + " is done writing." );

            //semaphore.P();
                dataBase.endWrite();
            //semaphore.V();

        }
    }
    
}
