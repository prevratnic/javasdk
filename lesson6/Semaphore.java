package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 29.03.12
 * Time: 22:44
 */

public class Semaphore {

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
