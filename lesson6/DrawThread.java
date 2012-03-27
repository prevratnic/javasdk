package lesson6;

import javax.swing.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.03.12
 * Time: 18:38
 */

public class DrawThread {
    
    private JFrame jFrame;
    private JPanel jPanel;

    public DrawThread(){
        jFrame = new JFrame();
        jFrame.setTitle( "zzz- I/O" );
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);

        this.initScrollPanel();

        jFrame.setVisible( true );

    }

    private void initScrollPanel(){
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout( jPanel , BoxLayout.Y_AXIS ));

        JScrollPane jScrollPane = new JScrollPane( jPanel );
        
        jFrame.add( jScrollPane );
    }


}
