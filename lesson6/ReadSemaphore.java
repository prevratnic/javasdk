package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 19:40
 */

public class ReadSemaphore {

    private int value;

    public ReadSemaphore(int value){
        this.value = value;
    }

    public synchronized void P(){
        value--;
    }

    public synchronized void V(){
        notify();
        value++;
    }

    public synchronized void check() {
        while (value <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
