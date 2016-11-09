/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Student
 */
public class GuiShowHand extends JFrame{
    
   public GuiShowHand(ArrayList<Card> deckcards)
   {
       
       this.setLayout(new GridLayout(1,5,1,1));
      for(Card card:deckcards)
      {
           String path = "";
        
        
        if(card.toString().substring(0,1).equals("#"))
            {
                
                path = "images/"+card.toString().substring(1)+"_of_hearts.png";
               
            }
            else if(card.toString().substring(0,1).equals("$"))
            {
                path = "images/"+card.toString().substring(1)+"_of_clubs.png";
            }
             else if(card.toString().substring(0,1).equals("%"))
            {
                path = "images/"+card.toString().substring(1)+"_of_diamonds.png";
            }
            
             else if(card.toString().substring(0,1).equals("&"))
            {
                path = "images/"+card.toString().substring(1)+"_of_spades.png";
            }
            BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(path));
            Image dimg=myPicture.getScaledInstance(80, 120,
        Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(dimg));
           this.add(picLabel);
        } catch (IOException ex) {
            //Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

     this.setSize(500, 200);
       this.setVisible(true);
   }
    
}
