package lesson3;

import javax.swing.*;


/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.03.12
 * Time: 15:15
 */

public class DrawTest {

    private JFrame frame;

    public DrawTest(){
        frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle("DrawTest");
        frame.setSize(300, 400);
        frame.setContentPane( new DrawPrimitive() );
        frame.setVisible( true );
    }

}
