import javax.swing.*;
/************************
 * CSCI 185 FAll 2023 12/15/23
 *Final Project
 * Jonathan Guaman, Vincet Zhang, Shankalpa Duwadi
 * ************************
 */
public class Background extends JPanel{
	
	ImageIcon image;
    JLabel background;
    ImageIcon begin; // First scree user sees
	
	Background()
    {
		
	    image = new ImageIcon("BImage.jpg");  //IMage 
        background = new JLabel(image,JLabel.CENTER);// making the label contain the background or it wont work
        background.setBounds(0, 0, 623, 485); //positiong of background
        this.add(background);
        

	}
   
}
