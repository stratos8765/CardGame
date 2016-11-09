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
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "A"
        };
     String[] SUITS = {
            "&", "%", "#", "$"
        };
     int n = SUITS.length * RANKS.length;
    
    public Deck()
    {
          for (int i = 0; i < RANKS.length; i++) 
          {  
            for (int j = 0; j < SUITS.length; j++) 
            {
                Card newcard = new Card();
                newcard.setNumber(RANKS[i]);
                newcard.setType(SUITS[j]);            
                deck.add(newcard);
            }
          }
        }

    public ArrayList<Card> getDeck() {
        return deck;
    }
    

    }
    

    
    
