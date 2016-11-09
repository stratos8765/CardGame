/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg2;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class HeartsPlayer extends Human implements CardsPlayer {
    
   private ArrayList<Card> hand = new ArrayList<Card>();
   private int totalscore;
   private int totalhearts;
   
    public HeartsPlayer()
    {
        super();
        this.hand = new ArrayList<Card>();
        this.totalscore=0;
        this.totalhearts=0;
        
        
    }
    
        public HeartsPlayer(String name,String lastname,int age,ArrayList<Card> hand,int totalscore,int totalhearts)
    {
        super(name,lastname,age);
        this.hand = hand;     
        this.totalscore=totalscore;
        this.totalhearts=totalhearts;
        
    }

    public ArrayList<Card> getHand() 
    {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) 
    {
        this.hand = hand;
    }

     public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getTotalhearts() {
        return totalhearts;
    }

    public void setTotalhearts(int totalhearts) {
        this.totalhearts = totalhearts;
    }

    @Override
    public void showHand() 
    {
       for(Card card:hand)
       {
           System.out.println(card.toString());
       }
      
    }

   
    
}
