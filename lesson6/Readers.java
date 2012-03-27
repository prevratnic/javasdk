package lesson6;

import static lesson6.DataBase.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 20:08
 */

public class Readers implements Runnable {
    
    private DataBase dataBase;
    private Semaphore semaphore;
    private int indexThread;

    public Readers(int indexThread, DataBase dataBase, Semaphore semaphore){
        
        this.indexThread = indexThread;
        this.dataBase = dataBase;
        this.semaphore = semaphore;
        
        Thread thread = new Thread( this, "Readers" );
        thread.start();
        
    }

    @Override
    public void run() {
        
        int count = 0;
        
        for(int i = 0; i < 3; i++){
            System.err.println("Reader " + indexThread + " is sleeping.");

            timeSleep();

            semaphore.P();
            // Critical section
            count = dataBase.startRead();

            System.err.println("Reader " + indexThread + " wants to read.");
            System.err.println("Reader " + indexThread + " is reading. Reader Count = " + count);

            timeSleep();

            count = dataBase.endRead();
            // Not critical section
            semaphore.V();
        }
    }
    
}
