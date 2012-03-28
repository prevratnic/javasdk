package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 19:28
 */

public class DataBase {

    private ReadSemaphore read;
    private WriteSemaphore write;

    private int readerCount;
    private boolean dbReading;
    private boolean dbWriting;

    public DataBase(){
        read = new ReadSemaphore(1);
        write = new WriteSemaphore(1);
    }
    
    public void startRead(){
        write.P();
            read.P();
        write.V();
        readerCount++;
        dbReading = true;
    }

    public void endRead(){
        readerCount--;
        read.V();
    }

    public void startWrite(){
        write.P();
            read.check();
        dbWriting = true;

    }

    public void endWrite(){

        dbWriting = false;
        write.V();
    }

    public static void sleepTime(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
