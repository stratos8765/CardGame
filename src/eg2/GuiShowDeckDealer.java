/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg2;

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
import javax.swing.JPanel;

/**
 *
 * @author Student
 */
public class GuiShowDeckDealer
{
   public ArrayList<JLabel> cards= new ArrayList<JLabel>();
   public int i=0;
   
    public GuiShowDeckDealer(ArrayList<Card> cards1 , ArrayList<Card> cards2,ArrayList<Card> cardsdealer)
    {
        ArrayList<ArrayList<Card>> playerdecks = new ArrayList<ArrayList<Card>>();
        playerdecks.add(cards1);
        playerdecks.add(cards2);
        //playerdecks.add(cardsdealer);

            for(Card card:cardsdealer)
            {
                 String path = "";
        
        
        if(card.toString().substring(0,1).equals("#"))
            {
                
                path = "images/"+card.toString().substring(1)+"_of_hearts.png";
                JLabel cardlabel = new JLabel(path);
                cards.add(cardlabel);
               
            }
            else if(card.toString().substring(0,1).equals("$"))
            {
                path = "images/"+card.toString().substring(1)+"_of_clubs.png";
                JLabel cardlabel = new JLabel(path);
                cards.add(cardlabel);
            }
             else if(card.toString().substring(0,1).equals("%"))
            {
                path = "images/"+card.toString().substring(1)+"_of_diamonds.png";
                JLabel cardlabel = new JLabel(path);
                cards.add(cardlabel);
            }
            
             else if(card.toString().substring(0,1).equals("&"))
            {
                path = "images/"+card.toString().substring(1)+"_of_spades.png";
                JLabel cardlabel = new JLabel(path);
                cards.add(cardlabel);
            }
            
            }
        
        //for(Card card:cardsdealer)
        //{
          //  String path="images/back.png";
          // JLabel cardlabel = new JLabel(path);
         //       cards.add(cardlabel);
        //}
    }
    public ArrayList<JLabel> getCards()
    {
        return this.cards;
        
    }

}
