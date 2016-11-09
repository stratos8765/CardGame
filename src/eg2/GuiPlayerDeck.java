/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 3oxic
 */
public class GuiPlayerDeck{
    public int i;
    public JLabel[] deckcard = new JLabel[5];
    public JPanel deckpanel = new JPanel();
    
    public GuiPlayerDeck()
    {
        deckpanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        for(int i =0 ;i<5 ;i ++)
        {
           deckcard[i]= new JLabel("test");
           deckcard[i].setMinimumSize(new Dimension(80, 120));
           deckcard[i].setPreferredSize(new Dimension(80, 120));
           deckcard[i].setMaximumSize(new Dimension(80, 120));
           deckcard[i].setForeground(Color.white);
           deckcard[i].setBackground(Color.white);
           deckcard[i].setOpaque(true);
           deckpanel.add(deckcard[i],c);
           c.gridx++;
        }
        deckpanel.setPreferredSize(new Dimension(550,150));
        deckpanel.setSize(550,150 );
        deckpanel.setVisible(true);
    }
    
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public JLabel getDeckcard() {
        return deckcard[i];
    }

    public void setDeckcard(JLabel deckcard) {
        String path = "images/back.png";
        
        //this.deckcard[i].setText(deckcard.getText());
        if(deckcard.getText().toString().substring(0,1).equals("#"))
            {
                this.deckcard[i].setText("images/"+deckcard.getText().toString().substring(1)+"_of_hearts.png");
               // path = "images/"+deckcard.getText().toString().substring(1)+"_of_hearts.png";
               
            }
            else if(deckcard.getText().toString().substring(0,1).equals("$"))
            {
                this.deckcard[i].setText("images/"+deckcard.getText().toString().substring(1)+"_of_clubs.png");
               // path = "images/"+deckcard.getText().toString().substring(1)+"_of_clubs.png";
            }
             else if(deckcard.getText().toString().substring(0,1).equals("%"))
            {
                this.deckcard[i].setText("images/"+deckcard.getText().toString().substring(1)+"_of_diamonds.png");
               // path = "images/"+deckcard.getText().toString().substring(1)+"_of_diamonds.png";
            }
            
             else if(deckcard.getText().toString().substring(0,1).equals("&"))
            {
                this.deckcard[i].setText("images/"+deckcard.getText().toString().substring(1)+"_of_spades.png");
                //path = "images/"+deckcard.getText().toString().substring(1)+"_of_spades.png";
            }
            BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(path));
            Image dimg=myPicture.getScaledInstance(80, 120,
        Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(dimg));
            this.deckcard[i].setIcon(picLabel.getIcon());
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        i++;
    }
    public void showhandcards()
    {
        BufferedImage myPicture;
        for(JLabel card:deckcard)
        {
           
            try {
            myPicture = ImageIO.read(new File(card.getText()));
            Image dimg=myPicture.getScaledInstance(80, 120,
        Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(dimg));
            card.setIcon(picLabel.getIcon());
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public JPanel getDeckpanel() {
        return deckpanel;
    }

    public void setDeckpanel(JPanel deckpanel) {
        this.deckpanel = deckpanel;
    }
    
    
}
