package test;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 27.03.12
 * Time: 15:11
 */

public class MyTestThread {
    public static void main(String... args){

        TestDateBase dateBase = new TestDateBase();

        for(int i = 1; i < 5; i++){
            new TestReaders(dateBase, i);
            new TestWriters(dateBase, i);
        }

    }
}

class TestDateBase {

    private int readerCount;
    private boolean dbReading;
    private boolean dbWriting;
    private Semaphore read = new Semaphore(1);
    private Semaphore write = new Semaphore(1);

    public void startRead(){
        read.P();
            if(dbWriting){
                write.P();
            }

            readerCount++;

            if(readerCount == 1){
                dbReading = true;
            }
        read.V();
    }

    public void endRead(){
        read.P();
            readerCount--;

            if( readerCount == 0 ){
                dbReading = false;
                write.V();
            }
        read.V();
    }

    public void startWrite(){
        write.P();
        if( dbReading || dbWriting ){
            write.P();
        }

        dbWriting = true;
    }

    public void endWrite(){
        dbWriting = false;
        write.V();
    }

    public static void sleepTime(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class TestReaders implements Runnable{

    private TestDateBase dateBase;
    private int indexThread;

    public TestReaders( TestDateBase dateBase, int indexThread ){

        this.dateBase = dateBase;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Поток Readers № " + indexThread + " спит");
            TestDateBase.sleepTime();

            dateBase.startRead();
            System.out.println("    Поток Readers № " + indexThread + " начал чтение");

            TestDateBase.sleepTime();

            dateBase.endRead();
            System.out.println("    Поток Readers № " + indexThread + " закончил чтение");
        }
    }
}

class TestWriters implements Runnable {

    private TestDateBase dateBase;
    private int indexThread;

    public TestWriters( TestDateBase dateBase, int indexThread ){

        this.dateBase = dateBase;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Поток № Writers " + indexThread + " спит");
            TestDateBase.sleepTime();

            dateBase.startWrite();
            System.out.println("    Поток Writers № " + indexThread + " начал чтение");

            TestDateBase.sleepTime();

            dateBase.endWrite();
            System.out.println("    Поток Writers № " + indexThread + " закончил чтение");
        }
    }

}

class Semaphore {

    private int value;

    public Semaphore(int value){
        this.value = value;
    }

    public synchronized void P(){

        while (value <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        value--;
    }

    public synchronized void V(){
        notify();
        value++;
    }
}

