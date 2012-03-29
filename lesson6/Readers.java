package lesson6;

import static lesson6.DataBase.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 20:08
 */

public class Readers implements Runnable {

    private DataBase dataBase;
    private int indexThread;

    public Readers( DataBase dataBase, int indexThread ){

        this.dataBase = dataBase;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            sleepTime();
            dataBase.startRead();
            System.out.println("Поток Readers № " + indexThread + " начал чтение");

            sleepTime();
            System.out.println("Поток Readers № " + indexThread + " закончил чтение");
            dataBase.endRead();
        }
    }

}
