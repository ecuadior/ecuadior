
import javax.swing.*;
import java.util.Random;
/************************
 * CSCI 185 FAll 2023 12/15/23
 *Final Project
 * Jonathan Guaman, Vincet Zhang, Shankalpa Duwadi
 * ************************
 */
public class Groudon extends JPanel {

    ImageIcon groudonIcon;
    JLabel GroudonLabel;
    public int GroudonDamage;
    Random r = new Random();
    public Groudon() {
        // Load Groudon image
        groudonIcon = new ImageIcon("Groudan_1.gif");
        GroudonLabel = new JLabel(groudonIcon);
        GroudonLabel.setBounds(330,20, groudonIcon.getIconWidth(), groudonIcon.getIconHeight());
    }
    

}
