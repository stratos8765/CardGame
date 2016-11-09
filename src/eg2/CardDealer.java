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
public interface CardDealer {
    void showDeck();
    Card dealRandomCard();
    void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2); 
    void decideWinner(HeartsPlayer player1, HeartsPlayer player2); 
    
}
