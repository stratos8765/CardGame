/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg2;

/**
 *
 * @author Student
 */
public class Card {
    private String number;
    private String type;

 
    public Card()
    {
        this.number=" ";
        this.type=" ";
         
    }
    
    
   public Card(String type,String number)
    {
        this.type = type;
        this.number = number;
        
    }
        
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String toString()
    {
     String str = this.type + this.number;
     return str;
     
    }
    
        public void setString(String fullcard)
    {
     this.number=fullcard.substring(1);
     this.type = fullcard.substring(2);
     
    }
    
}
