import javax.swing.*;
import java.util.Random;
/************************
 * CSCI 185 FAll 2023 12/15/23
 *Final Project
 * Jonathan Guaman, Vincet Zhang, Shankalpa Duwadi
 * ************************
 */

public class CharizardPanel extends JPanel 
{

    ImageIcon charizardIcon;
    JLabel charizardLabel;
    JPanel CharizardMoves; // panel to call
    JButton moves[]= new JButton[4]; // moves he would have 
    public int damage=0;// caculate the damage a move do to Groudon health
    Random r = new Random();

    public CharizardPanel() {
        // Load Charizard image
        
        charizardIcon = new ImageIcon("GifTest.gif");  // Replace "charizard.png" with the actual path to your Charizard image file

        // Create label and set the icon
        charizardLabel = new JLabel(charizardIcon);

        // Set the bounds for the label (adjust values accordingly)
        charizardLabel.setBounds(30, 180, charizardIcon.getIconWidth(), charizardIcon.getIconHeight());

        //His moves
      
    }
}

