package lesson6;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 18:36
 */

public class MainGUI {

//    public static void main(String[] args){
//        SwingUtilities.invokeLater( new Runnable() {
//            @Override
//            public void run() {
//                new DrawThread();
//            }
//        });
//    }
    
    
    public static void main(String... args){

        Semaphore semaphore = new Semaphore(1);

        DataBase dataBase = new DataBase();
        
        for( int i = 1; i < 6; i++ ){
            new Readers( i, dataBase, semaphore );
         //   new Writers( i, dataBase );
        }

    }

}
