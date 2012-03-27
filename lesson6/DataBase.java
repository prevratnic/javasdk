package lesson6;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 19:28
 */

public class DataBase {

    private int readerCount;
    private boolean dbReading;
    private boolean dbWriting;
    private Semaphore semaphore;

    public DataBase( Semaphore semaphore ){
        this.readerCount = 0;
        this.dbReading = false;
        this.dbWriting = false;
    }
    
    public synchronized int startRead(){

        while (dbWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ++readerCount;
        
        if( readerCount == 1 ){
            dbReading = true;
        }

        return readerCount;

    }

    public synchronized int endRead(){
        --readerCount;
        if( readerCount == 0 )
            dbReading = false;

        System.err.println( "Reader is done reading. Count = " + readerCount ); //todo

        return readerCount;
    }

    public synchronized void startWrite(){

       while (dbReading || dbWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dbWriting = true;

    }

    public synchronized void endWrite(){
        dbWriting = false;
        notifyAll();
    }

    public static void timeSleep(){
        try {
            Thread.sleep( (int)(Math.random() * 3000) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
