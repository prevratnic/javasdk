package lesson3;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.03.12
 * Time: 15:11
 */

public class MainGUI {

    public static void main(String[] args){

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new DrawTest();
            }
        });

    }
}
