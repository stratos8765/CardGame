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
public class Eg2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      HeartsDealer dealer= new HeartsDealer();
      HeartsPlayer player1 = new HeartsPlayer();
      HeartsPlayer player2 = new HeartsPlayer();
      
      
    
      Gui gui1 = new Gui(dealer,player1,player2);
     RegisterGui reg = new RegisterGui(player1,player2,dealer,new RegisterGuest());
// guidetails.setLocation(gui1.getX() + gui1.getWidth(), gui1.getY());
      //guidetails2.setLocation(gui1.getX() + gui1.getWidth(), gui1.getX());
     
    }
    
}
