/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg2;

import java.awt.TextArea;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Student
 */
public class HeartsDealer extends Human implements CardDealer {
    private Deck deck = new Deck();
    private ArrayList<Card> hand1 = new ArrayList<Card>();
    private ArrayList<Card> hand2 = new ArrayList<Card>();
    private JTextArea log = new JTextArea();
    private int round;
    
    
    public HeartsDealer()
    {
        super();
        this.deck = new Deck();
        this.log = new JTextArea();
        this.round=1;
    }
    
   public HeartsDealer(String name,String lastname,int age,Deck deck,JTextArea log,int round)
   {
       super(name,lastname,age);
       this.deck=deck;
       this.log=log;
       this.round=round;
   }
   
    @Override
    public void showDeck() {
       for(Card card:deck.getDeck())
       {
           System.out.println(card);
       }
    }

    public Deck getDeckDealer() {
        return deck;
    }

    public void setDeckDealer() {
        this.deck = deck;
    }
    
    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round=round;
    }
    
    public void setLog(JTextArea log) {
        this.log = log;
    }
    public JTextArea getLog()
    {
        return this.log;
    }

    @Override
    public Card dealRandomCard() {
        
   
        int r = 0 + (int) (Math.random() * (deck.getDeck().size()));
        Card temp=this.deck.getDeck().get(r);
        this.deck.getDeck().remove(temp);
        return temp;
    }

    @Override
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) {


        hand1.add(dealRandomCard());
        hand2.add(dealRandomCard());
        player1.setHand(hand1);
        player2.setHand(hand2);
        
    }
    public void shuffleCards()
    {
        int i =0;
        for(Card card:deck.getDeck())
        {
           int r = i + (int) (Math.random() * (deck.getDeck().size()-i));
           Card tempcard = new Card();
          
           tempcard=deck.getDeck().get(r);
           deck.getDeck().set(r, card);
           deck.getDeck().set(i,tempcard);
           i++;
           
        }
    }

    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2)
    {
        player1.setTotalscore(0);
        player2.setTotalscore(0);
        player1.setTotalhearts(0);
        player2.setTotalhearts(0);
        
        for(int i = 0 ; i<player1.getHand().size();i++)
        {
            if(player1.getHand().get(i).toString().substring(0,1).equals("#"))
            {
                player1.setTotalhearts(player1.getTotalhearts() + 1);
                
            }
            if(player2.getHand().get(i).toString().substring(0,1).equals("#"))
            {
                player2.setTotalhearts(player2.getTotalhearts() + 1);
                
            }
        }
           if(player1.getTotalhearts()>player2.getTotalhearts())
   {
       player1.setTotalscore(player1.getTotalscore()+((player1.getTotalhearts()-player2.getTotalhearts())*10));
   }
   else if(player2.getTotalhearts()>player1.getTotalhearts())
   {
   
       player2.setTotalscore(player2.getTotalscore()+((player2.getTotalhearts()-player1.getTotalhearts())*10));
      
   }

    }
   
    
}
