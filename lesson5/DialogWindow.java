package lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static lesson5.ContextManager.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 21:19
 */

public class DialogWindow implements ActionListener {
    
    private JFrame jFrame;
    
    private JTextField firstInput, secondInput;
    private JButton acceptButton, clearButton, closeButton;
    private JLabel hintText;
    private User user;

    public DialogWindow( User user ){
        
        this.user = user;
        
        this.jFrame = new JFrame();
        this.jFrame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        this.jFrame.setTitle( user == User.STUDENT ? "Student From" : "Faculty From" );
        this.jFrame.setSize(400, 150);
        this.jFrame.setLayout( new GridLayout(3, 1) );
        
        this.initField();
        this.initButton();
        this.initAction();
        this.initText();
        
        this.jFrame.setResizable( false );
        this.jFrame.setVisible(true);
    }

    private void initField(){
        
        JPanel panelField = new JPanel();

        this.firstInput = new JTextField();
        this.firstInput.setColumns(10);

        this.secondInput = new JTextField();
        this.secondInput.setColumns(10);

        panelField.add( new JLabel("Name :") );
        panelField.add( firstInput );
        panelField.add( new JLabel( user == User.STUDENT ? "Age :" : "Degree :" ) );
        panelField.add( secondInput );

        this.jFrame.add( panelField );

    }

    private void initButton(){

        JPanel panelButton = new JPanel();

        this.acceptButton = new JButton("Accept");
        this.clearButton = new JButton("Clear");
        this.closeButton = new JButton("Close");

        panelButton.add( acceptButton );
        panelButton.add( clearButton );
        panelButton.add( closeButton );

        this.jFrame.add( panelButton );

    }

    private void initAction(){                
        this.acceptButton.addActionListener( this );
        this.clearButton.addActionListener( this );
        this.closeButton.addActionListener( this );
    }

    private void initText(){

        JPanel panelText = new JPanel();
        panelText.add( hintText = new JLabel() );

        this.jFrame.add( panelText );

    }

    private void messageHint( boolean b){
        
        if(b){
            hintText.setText("ACCEPTED");
        }else {
            hintText.setText("NOT ACCEPTED");
        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();
        
        if( source == acceptButton ){
            this.messageHint( addItem() );
        } else if( source == clearButton ){
            this.clearField();
            this.clearMassage();
        } else if( source == closeButton ){
            this.jFrame.dispose();
        }

    }

    private boolean addItem(){

        if( counter < universityArray.length ){

            if( firstInput.getText().length() > 0 && secondInput.getText().length() > 0 ){
                if( user == User.STUDENT ){
                    try{
                        int age = Integer.valueOf( secondInput.getText() );
                        if( age < 16 || age > 80 ) return false;
                        universityArray[ counter++ ] = new Student( firstInput.getText(), age );

                        this.clearField();

                        return true;

                    } catch (NumberFormatException e){
                        return false;
                    }
    
                } else{
                    universityArray[ counter++ ] = new Faculty( firstInput.getText(), secondInput.getText() );

                    this.clearField();

                    return true;
                }
    
            }
            
        }

        return false;
    }

    private void clearField(){
        this.firstInput.setText("");
        this.secondInput.setText("");
    }

    private void clearMassage(){
        this.hintText.setText("");
    }


}
