package lesson4;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 11.03.12
 * Time: 18:09
 */

public class DrawWindow {

    public DrawWindow(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setTitle("Lab 4");
        jFrame.setContentPane( new ButtonPanel() );
        jFrame.setSize( 400, 400 );
        jFrame.setResizable( false );
        jFrame.setVisible(true);
    }

}
