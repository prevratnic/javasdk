package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 28.03.12
 * Time: 17:05
 */
public class WriteSemaphore {

    private int value;

    public WriteSemaphore(int value){
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
