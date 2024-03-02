import java.awt.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
/************************
 * CSCI 185 FAll 2023 11/30/23
 * M7: GUI Basics Lab (*SOLO*)
 * Jonathan Guaman
 * ************************
 */

public class UpperLowerConvert {
    //Setting up frame
    JFrame frame;
    Font font;
    JTextArea text;
    JTextField input;
    JButton upper, lower, clear;
    public UpperLowerConvert()
    {
     frame = new JFrame("Upper/Lower case Convertor");
    font = new Font("Ink free", Font.BOLD, 30); //Setting up the font for the label and text when import
    
     text = new JTextArea();//First text field to display result
     input = new JTextField();// use to display user inputn
    frame.setSize(500, 375);
    frame.setVisible(true);
    frame.setResizable(false); // stops user from changing size 
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     upper = new JButton("Upper");
     lower = new JButton("Lower");
     clear = new JButton("clear");

    upper.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            text.setText(input.getText().toUpperCase());
        }
     });
     lower.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            text.setText(input.getText().toLowerCase());
        }
     });
    clear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            text.setText("");
            input.setText("");
            input.requestFocus();
        }
    });
    JPanel panel = new JPanel(); //Panel for the 3 buttons 
    JPanel panel2 = new JPanel();// Pannel for the label 
    JPanel panel3 = new JPanel();// Pannel for second label 
    panel.setBounds(0,2,120,200); // Dimensions for the Button
    panel2.setBounds(150,250,200,200); //Dimesnions for label
    panel3.setBounds(150,5,200,200); //Dimesnions for label
    
    
    panel.add(upper);
    panel.add(lower);
    panel.add(clear);
    // Label to show user where they are going to type and result
    JLabel label = new JLabel("Enter text");
    JLabel label2 = new JLabel("Result");
    label.setFont(font);
    label2.setFont(font);
    panel2.add(label);
    panel3.add(label2);
    // add label to new pannel 

    text.setBounds(100, 50, 300, 200);
    text.setEditable(false);
    input.setBounds(100,300,300,30);
    
    frame.add(text);
    frame.add(input);
    frame.add(panel);
    frame.add(panel2);
    frame.add(panel3);
    }
    
   
    public static void main(String[] args)
    {
        UpperLowerConvert ULC = new UpperLowerConvert();
    }




    

   
}
