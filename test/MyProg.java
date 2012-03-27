package test;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 27.03.12
 * Time: 11:30
 */

public class MyProg {
    public static void main(String[] args) {

        Database myDB = new Database();

        Reader reader1 = new Reader(1, myDB);
        Reader reader2 = new Reader(2, myDB);
        Reader reader3 = new Reader(3, myDB);
        Reader reader4 = new Reader(4, myDB);
        Reader reader5 = new Reader(5, myDB);

        Writer writer1 = new Writer(1, myDB);
        Writer writer2 = new Writer(2, myDB);
        Writer writer3 = new Writer(3, myDB);
        Writer writer4 = new Writer(4, myDB);

        writer1.start();
        writer2.start();
        writer3.start();
        writer4.start();

        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();

    }
}

class Reader extends Thread {
    public Reader(int r, Database db) {
        readerNum = r;
        server = db;
    }

    public void run() {
        int c;
        for (int i = 1; i <= 3; i++) // It should be while (true)
        {   System.err.println("reader " + readerNum + " is sleeping.");
            Database.napping();
            c = server.startRead();

            System.err.println("reader " + readerNum + " wants to read.");
            // you have access to read from the database
            System.err.println("reader " + readerNum + " is reading. Reader Count = " + c);
            Database.napping();

            c = server.endRead();
        }
    }

    private Database server;
    private int readerNum;
}

class Writer extends Thread {

    public Writer(int w, Database db) {
        writerNum = w;
        server = db;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) // It should be while (true)
        {
            System.err.println("writer " + writerNum + " is sleeping.");
            Database.napping();
            System.err.println("writer " + writerNum + " wants to write.");
            server.startWrite();

            // you have access to write to the database
            System.err.println("               writer " + writerNum + " is writing.");
            Database.napping();

            System.err.println("               writer " + writerNum + " is done writing.");
            server.endWrite();

        }
    }

    private Database server;
    private int writerNum;
}

// This class contains the methods the readers and writers will use
// to coordinate access to the database. Access is coordinated using semaphores.
class Database {

    public Database() {
        readerCount = 0;
        dbReading = false;
        dbWriting = false;
    }

    public static void napping()  // readers and writers will call this to nap
    {
        try {
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int startRead() {
        if (dbWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++readerCount;
        if (readerCount == 1)  // if I am the first reader tell all others
            dbReading = true;    // that the DB is being read
        return readerCount;
    }

    public synchronized int endRead() {
        --readerCount;
        if (readerCount == 0)  // if I am the last reader tell all others
            dbReading = false;  // that the database is no longer being read
        System.err.println("Reader is done reading. Count = " + readerCount);
        notifyAll();
        return readerCount;
    }

    public synchronized void startWrite() {
        if (dbReading || dbWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dbWriting = true; // the DB is being written
    }

    public synchronized void endWrite() {
        dbWriting = false;
        notifyAll();
    }

    private int readerCount;    // the number of active readers
    private boolean dbReading;  // flags to indicate whether the DB
    private boolean dbWriting;  // is being read or written

}