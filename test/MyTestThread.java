package test;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 27.03.12
 * Time: 15:11
 */

public class MyTestThread {
    public static void main(String... args){

        Semaphore semaphore = new Semaphore(1);

        TestDateBase dateBase = new TestDateBase( semaphore );

        for(int i = 1; i < 5; i++){
            new TestReaders(dateBase, i, semaphore);
            new TestWriters(dateBase, i, semaphore);
        }

    }
}

class TestDateBase {

    private int readerCount;
    private boolean dbReading;
    private boolean dbWriting;
    private Semaphore semaphore;

    public TestDateBase(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void startRead(){
        if(dbWriting){

//            try {
//                wait(); // todo: thread waiting for execution Write
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        readerCount++;

        if(readerCount == 1){
            dbReading = true;
        }
    }

    public void endRead(){

        readerCount--;

        if( readerCount == 0 ){
            dbReading = false;
        }

     //   notifyAll();

    }

    public synchronized void startWrite(){
        if( dbReading || dbWriting ){
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
    private Semaphore semaphore;
    private int indexThread;

    public TestReaders( TestDateBase dateBase, int indexThread, Semaphore semaphore ){

        this.dateBase = dateBase;
        this.semaphore = semaphore;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            semaphore.P();
                System.out.println("Поток Readers № " + indexThread + " спит");
                TestDateBase.sleepTime();

                dateBase.startRead();
                System.out.println("    Поток Readers № " + indexThread + " начал чтение");

                TestDateBase.sleepTime();

                dateBase.endRead();
                System.out.println("    Поток Readers № " + indexThread + " закончил чтение");
            semaphore.V();
        }
    }
}

class TestWriters implements Runnable {

    private TestDateBase dateBase;
    private Semaphore semaphore;
    private int indexThread;

    public TestWriters( TestDateBase dateBase, int indexThread, Semaphore semaphore ){

        this.dateBase = dateBase;
        this.semaphore = semaphore;
        this.indexThread = indexThread;

        new Thread( this, this.getClass().getName() ).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
          //  semaphore.P();
                System.out.println("Поток № Writers " + indexThread + " спит");
                TestDateBase.sleepTime();

                dateBase.startWrite();
                System.out.println("    Поток Writers № " + indexThread + " начал чтение");

                TestDateBase.sleepTime();

                dateBase.endWrite();
                System.out.println("    Поток Writers № " + indexThread + " закончил чтение");
          //  semaphore.V();
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

