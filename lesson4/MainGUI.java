package lesson4;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 11.03.12
 * Time: 18:04
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
