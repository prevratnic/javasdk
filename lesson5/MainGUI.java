package lesson5;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 17:00
 */

public class MainGUI {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawWindow();
            }
        });
    }

}
