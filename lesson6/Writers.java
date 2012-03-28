package lesson6;

import static lesson6.DataBase.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 20:08
 */

public class Writers implements Runnable {

    private DataBase dataBase;
    private int indexThread;

    public Writers( DataBase dataBase, int indexThread ){

        this.dataBase = dataBase;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 2; i++){
            sleepTime();
            dataBase.startWrite();
            System.out.println("Поток Writers № " + indexThread + " начал чтение");

            sleepTime();
            dataBase.endWrite();
            System.out.println("Поток Writers № " + indexThread + " закончил чтение");
        }
    }

}
