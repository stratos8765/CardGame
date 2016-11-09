/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 3oxic
 */
public class RegisterGui extends JFrame {
    public HeartsPlayer player;
    public HeartsPlayer player2;
    public HeartsDealer dealer;
    public JTextField username;
    public JTextField lastname;
    public JTextField age;
    public RegisterGuest guest1;
    public RegisterGui(final HeartsPlayer player, final HeartsPlayer player2, final HeartsDealer dealer,RegisterGuest reg)
    {
          this.guest1=reg;
      
      
        this.player=player;

        this.player=player;

        this.player2=player2;

        this.dealer = dealer;
        this.setSize(350,600);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.anchor=GridBagConstraints.PAGE_START;
        c.weightx=1.0;
        c.weighty=1.0;
        c.ipadx=20;
        c.gridwidth=2;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,110,0,0);
        JLabel playerinfolabel =new JLabel("Add Player Info");
        this.add(playerinfolabel,c);
        c.insets = new Insets(0,0,0,0);
        c.gridwidth=1;
        c.ipadx=0;
        c.anchor = GridBagConstraints.LINE_START;
        JLabel usernamelabel = new JLabel("First Name:");
        this.add(usernamelabel,c);
        c.gridx++;
        username = new JTextField(20);
        this.add(username,c);
        c.gridx=0;
        c.gridy++;
        JLabel lastnamelabel = new JLabel("Last Name:");
        lastname = new JTextField(20);
        this.add(lastnamelabel,c);
        c.gridx++;
        
        this.add(lastname,c);
        c.gridy++;
        c.gridx=0;
        JLabel agelabel = new JLabel("Age:");
        this.add(agelabel,c);
        age = new JTextField(20);
        c.gridx++;
        
        this.add(age,c);
        JButton submitbutton = new JButton("Submit");
        c.gridy++;
        c.insets = new Insets(0,0,0,70);
        this.add(submitbutton,c);
        submitbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {  
                     if(guest1.isDealerf())
                {

                   dealer.setName(username.getText());
                   dealer.setSurname(lastname.getText());
                   dealer.setAge(Integer.parseInt(age.getText()));
                   guest1.setDealerf(false);
                   closeme();
                 }
                    if(guest1.isPlayer2f())
                {

                   player2.setName(username.getText());
                   player2.setSurname(lastname.getText());
                   player2.setAge(Integer.parseInt(age.getText()));
                   guest1.setPlayer2f(false);
                   guest1.setDealerf(true);
                   closeme();
                 }
                    if(guest1.isPlayer1f())
                {
                  
                   player.setName(username.getText());
                   player.setSurname(lastname.getText());
                   player.setAge(Integer.parseInt(age.getText()));
                   guest1.setPlayer1f(false);
                   guest1.setPlayer2f(true);
                   closeme();
                 }
                  
                 
 
           
                }
              });
        this.setVisible(true);
    }
    public void closeme()
    {
        RegisterGui gui2= new RegisterGui(player,player2,dealer,guest1);
        this.dispose();
    }
}
