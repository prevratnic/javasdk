package lesson5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 18:34
 */

public class ContextManager extends JPanel implements ActionListener {

    private JMenuItem menuStudent, menuFaculty, menuPrint;

    protected static University universityArray[] = new University[10];
    protected static int counter = 0;

    public ContextManager(){

        JMenuBar jMenuBar = new JMenuBar();

        menuStudent = new JMenuItem("Student Data");
        menuFaculty = new JMenuItem("Faculty Data");
        menuPrint = new JMenuItem("Print the list");
        
        jMenuBar.add( menuStudent );
        jMenuBar.add( menuFaculty );
        jMenuBar.add( menuPrint );
        
        this.add( jMenuBar );
        
        this.initAction();

    }

    private void initAction(){
        menuStudent.addActionListener( this );
        menuFaculty.addActionListener( this );
        menuPrint.addActionListener( this );
    }
    
    private void print(){
        if( counter > 0 ) {
            for( int i = 0; i < counter; i++ ){
                System.out.println( universityArray[i] );
            }
        } else {
            System.out.println("Array is Empty");
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        Object source = event.getSource();
        
        if( source == menuStudent ){
            new DialogWindow( User.STUDENT );
        } else if ( source == menuFaculty ){
            new DialogWindow( User.FACULTY );
        } else if ( source == menuPrint ){
            this.print();
        }

    }
}
