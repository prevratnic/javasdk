package lesson5;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 17:01
 */

public class DrawWindow {

    public DrawWindow(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setTitle("DS&A. Assignment 1");
        jFrame.setContentPane( new ContextManager() );
        jFrame.setSize( 400, 100 );
        jFrame.setResizable( false );
        jFrame.setVisible(true);
    }

}
