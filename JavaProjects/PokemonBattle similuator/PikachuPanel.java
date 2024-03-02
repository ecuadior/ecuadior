import javax.swing.*;
import java.util.Random;
/************************
 * CSCI 185 FAll 2023 12/15/23
 *Final Project
 * Jonathan Guaman, Vincet Zhang, Shankalpa Duwadi
 * ************************
 */

public class PikachuPanel extends JPanel {
    ImageIcon pikachuIcon;
    JLabel pikachuLabel; 
    int damage=0;// caculate how much damage he will do
    JButton moves[] = new JButton[4];// Caculate his moves
    JPanel pikachuMoves;// will hold the moves
    Random r = new Random();//use to caculate the damage a move will do;
    
    public PikachuPanel() {
        // Load Pikachu image
        pikachuIcon = new ImageIcon("Pikachu_1_1.gif");  // Replace "pikachu.png" with the actual path to your Pikachu image file

        // Create label and set the icon
        pikachuLabel = new JLabel(pikachuIcon);

        // Set the bounds for the label (adjust values accordingly)
        pikachuLabel.setBounds(30,300, pikachuIcon.getIconWidth(), pikachuIcon.getIconHeight());

        //Setting up moves and label that wil hold the moves
        

        
    }

   
}
