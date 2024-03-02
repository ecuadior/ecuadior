import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File; 
import javax.sound.sampled.*;
/************************
 * CSCI 185 FAll 2023 12/15/23
 *Final Project
 * Jonathan Guaman, Vincet Zhang, Shankalpa Duwadi
 * ************************
 */

public class Battle {
    //Calls thre Pokemon classes
    private CharizardPanel charizard;
    private PikachuPanel pikachu;
    private Groudon groudon;
    JLabel pikaTest = new JLabel();
    JLabel chartest= new JLabel();    
    JLabel groutest = new JLabel();

    JButton PikachuMoves[] = new JButton[4];
    JButton CharizardMoves[] = new JButton[4];

    private int pikachuHealth=250;
    private int CharizardHealth = 400;
    private int GroundonHealth =1000;

    JPanel PikaMoves = new JPanel(); //holds move
    JPanel CharMoves = new JPanel(); // holds 

    Random r = new Random();//use to caculate the damage a move will do;
   private int PikaDamage;
   private int CharDamage;
   private int GroudonDamage;
    
    
    public void WinOrLost()
   {
    //checks win or lose conditions
    if(pikachuHealth<=0 && CharizardHealth<=0)
    {
        JOptionPane.showMessageDialog(null,"You lose");
        System.exit(1);
    }
    else if(GroundonHealth<=0)
    {
        JOptionPane.showMessageDialog(null,"You Win");
        System.exit(1);
    }
   }
    public void GroudonAttack()
    {
        // Calculate Groudond damage 
        int Skill = r.nextInt(5);

        if(GroundonHealth>0) // Groudon will only attack when his health his over 0
        {
            switch (Skill) {

            case 0:
                GroudonDamage = r.nextInt(100-80+1)+80;
                
                JOptionPane.showMessageDialog(null, "Groudon uses EarthQuake\n It did "+GroudonDamage+" damage to you");
                break;

            case 1:
                GroudonDamage = r.nextInt(110-85+1)+85;
                JOptionPane.showMessageDialog(null, "Groudon uses Precipice Blades\n It did "+GroudonDamage+" damage to you");
                break;

            case 2:
               GroudonDamage = r.nextInt(120-95+1)+95;
                JOptionPane.showMessageDialog(null, "Groudon uses Fire Blast\n It did "+GroudonDamage+" damage to you");
                break;

            case 3:
                GroudonDamage = r.nextInt(110-75+1)+75;
                JOptionPane.showMessageDialog(null, "Groudon uses Eruption\n The Ground is Shaning\n It did "+GroudonDamage+" damage to you");
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "Attack faield\n Groudon felt nice");
                GroudonDamage=0;
                break;
        }
        }
        else // Groudon won't attack if his hp is 0 and visible to belive he "fainted"
        {
            JOptionPane.showMessageDialog(null, "Groudon fainted");
            groutest.setVisible(false);
        }
        
    }
    Battle()
    {
       
          
       charizard = new CharizardPanel();
       pikachu = new PikachuPanel();
       groudon = new Groudon();
       pikaTest = pikachu.pikachuLabel;
       chartest= charizard.charizardLabel;
       groutest = groudon.GroudonLabel;

       // Pikachu moves and button 
       PikaMoves.setLayout(new GridLayout(2,2,10,10)); 
       PikachuMoves[0] = new JButton("Thunderbolt");
       PikachuMoves[1] = new JButton("Quick Attack");
       PikachuMoves[2] = new JButton("Surf");
       PikachuMoves[3] = new JButton("Tackle");
       PikaMoves.add(PikachuMoves[0]);
       PikaMoves.add(PikachuMoves[1]);
       PikaMoves.add(PikachuMoves[2]);
       PikaMoves.add(PikachuMoves[3]);
       PikachuMoves[0].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            PikaDamage = r.nextInt(100-90+1)+90; // caculate amount of damage he does
            JOptionPane.showMessageDialog(null,"Pikachu use Thunderbolt!!\n"+"It did "+PikaDamage+" damage!");
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-PikaDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            pikachuHealth= pikachuHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Pikachu have hp"+pikachuHealth+" left");
            if(pikachuHealth<=0)
            {
                JOptionPane.showMessageDialog(null,"Pikachu have fainted");
                JOptionPane.showMessageDialog(null,"Go Charizard");
                PikaMoves.setVisible(false);
                pikaTest.setVisible(false);
                chartest.setVisible(true);
                CharMoves.setVisible(true);
            }
            WinOrLost();
            
        }
       }); 
        PikachuMoves[1].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            PikaDamage = r.nextInt(90-85+1)+85;
            JOptionPane.showMessageDialog(null,"Pikachu use Quick Attack!!\n"+"It did "+PikaDamage+" damage!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-PikaDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            pikachuHealth= pikachuHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Pikachu have "+pikachuHealth+"hp left");
            if(pikachuHealth<=0)
            {
                JOptionPane.showMessageDialog(null,"Pikachu have fainted");
                JOptionPane.showMessageDialog(null,"Go Charizard");
                PikaMoves.setVisible(false);
                //make pikachu gif false
                pikaTest.setVisible(false);
                chartest.setVisible(true);
                CharMoves.setVisible(true);
            }
            WinOrLost();
        }
       }); 
        PikachuMoves[2].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            PikaDamage = r.nextInt(135-100+1)+100;
            JOptionPane.showMessageDialog(null,"Pikachu use Surf!!\n"+"It did "+PikaDamage+" damage!\n Its Super Effective");
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-PikaDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            pikachuHealth= pikachuHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Pikachu have "+pikachuHealth+"hp left");
            if(pikachuHealth<=0)
            {
                JOptionPane.showMessageDialog(null,"Pikachu have fainted");
                JOptionPane.showMessageDialog(null,"Go Charizard");
                PikaMoves.setVisible(false);
                //make pikachu gif false
                pikaTest.setVisible(false);
                chartest.setVisible(true);
                CharMoves.setVisible(true);
            }
            WinOrLost();
            
        }
       }); 
        PikachuMoves[3].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            PikaDamage = r.nextInt(85-60+1)+60;
            JOptionPane.showMessageDialog(null,"Pikachu use Tackle!!\n"+"It did "+PikaDamage+" damage!");
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-PikaDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            pikachuHealth= pikachuHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Pikachu have "+pikachuHealth+"hp left");
            if(pikachuHealth<=0)
            {
                JOptionPane.showMessageDialog(null,"Pikachu have fainted");
                JOptionPane.showMessageDialog(null,"Go Charizard");
                PikaMoves.setVisible(false);
                //make pikachu gif false
                pikaTest.setVisible(false);
                chartest.setVisible(true);
                CharMoves.setVisible(true);
            }
            WinOrLost();
        }
       });
       //Charzard moves and damage 
       CharMoves.setLayout(new GridLayout(2,2,10,10));
       CharizardMoves[0] = new JButton("FlameThrower");
       CharizardMoves[1]= new JButton("Seismic Toss");
       CharizardMoves[2] = new JButton("Mega punch");
       CharizardMoves[3] = new JButton("Dragon tail"); 
       CharMoves.add(CharizardMoves[0]);
       CharMoves.add(CharizardMoves[1]);
       CharMoves.add(CharizardMoves[2]);
       CharMoves.add(CharizardMoves[3]);
       CharizardMoves[0].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            // Every button caculate the damage, how much health it has left, how much damage dealt to opponent and if they win or lose
           CharDamage = r.nextInt(90-75+1)+75;
            JOptionPane.showMessageDialog(null,"Charizard use FlameThrower!!\n"+"It did "+CharDamage+" damage!");
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-CharDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            CharizardHealth= CharizardHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Charizard have "+CharizardHealth+"hp left");
            if(CharizardHealth<=0)
            {
                CharMoves.setVisible(false);
                //make Charizard gif false
                chartest.setVisible(false);
            }
            WinOrLost();
        }
       }); 
       CharizardMoves[1].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            CharDamage = r.nextInt(120-100+1)+100;
            JOptionPane.showMessageDialog(null,"Charizard use Seismic Toss!!\n"+"It did "+CharDamage+" damage!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-CharDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            CharizardHealth= CharizardHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Charizard have "+CharizardHealth+"hp left");
            if(CharizardHealth<=0)
            {
                CharMoves.setVisible(false);
                chartest.setVisible(false);
            }
            WinOrLost();

            
        }
       }); 
       CharizardMoves[2].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            CharDamage = r.nextInt(85-75+1)+75;
            JOptionPane.showMessageDialog(null,"Charizard use Mega punch!!\n"+"It did "+CharDamage+" damage!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-CharDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            CharizardHealth= CharizardHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Charizard have "+CharizardHealth+"hp left");
            if(CharizardHealth<=0)
            {
                
                CharMoves.setVisible(false);
                chartest.setVisible(false);
            }
            WinOrLost();
           
        }
       }); 
       CharizardMoves[3].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e ) 
        {
            CharDamage = r.nextInt(95-90+1)+90;
            JOptionPane.showMessageDialog(null,"Charizard use Dragon tail!!\n"+"It did "+CharDamage+" damage!");
           try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GroundonHealth= GroundonHealth-CharDamage;
            JOptionPane.showMessageDialog(null, "Groudon has "+GroundonHealth+"hp left");
            GroudonAttack();
            CharizardHealth= CharizardHealth-GroudonDamage;
            JOptionPane.showMessageDialog(null, "Charizard have "+CharizardHealth+"gp left");
            if(CharizardHealth<=0)
            {
                CharMoves.setVisible(false);
                chartest.setVisible(false);
            }
            WinOrLost();
        }
       }); 
       
       // Music that plays

       int play = 4 ;

       while (play > 1){
        try 
        {
            File file = new File("Pokémon HeartGold & SoulSilver - Champion & Red Battle Music (HQ).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip c = AudioSystem.getClip();
            c.open(audioStream);
            c.start();
        } catch (Exception e) 
        {
        }

        play--;
    }
}
}

