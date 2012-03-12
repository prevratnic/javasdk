package lesson4;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 11.03.12
 * Time: 18:09
 */

public class DrawWindow {

    private JFrame jFrame;

    private int WIDTH = 400;
    private int HEIGHT = 400;

    public DrawWindow(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setTitle("Lab 4");
        jFrame.setContentPane( new ButtonPanel() );
        jFrame.setSize( WIDTH, HEIGHT );
        jFrame.setResizable( false );
        jFrame.setVisible(true);
    }

}
