package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 20:08
 */

public class Writers implements Runnable {

    private DataBase dataBase;
    private int indexThread;

    public Writers(int indexThread, DataBase dataBase){

        this.indexThread = indexThread;
        this.dataBase = dataBase;

        Thread thread = new Thread( this, "Writers");
        thread.start();

    }

    @Override
    public void run() {
        for( int i = 0; i < 10; i++ ){
            // что то происходит.
        }
    }
    
}
