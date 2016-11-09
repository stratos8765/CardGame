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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Student
 * to be rememberes
 */
public class Gui extends JFrame {
    public JPanel player1panel = new JPanel();
    public JPanel dealerpanel = new JPanel();
    public JPanel player2panel=new JPanel();
    public JPanel deck1panel = new JPanel();
    public JPanel deck2panel = new JPanel();
    public JPanel player1winninginfo = new JPanel();
    public JPanel player2winninginfo = new JPanel();
    
    public HeartsDealer dealer = new HeartsDealer();
    public HeartsPlayer player1 = new HeartsPlayer();
    public HeartsPlayer player2 = new HeartsPlayer();
    public GuiPlayerDeck deck1cards = new GuiPlayerDeck();
    public GuiPlayerDeck deck2cards = new GuiPlayerDeck();
    public JPanel deckdeckcards = new JPanel();
    JScrollPane deckdeckcards2 = new JScrollPane(deckdeckcards,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public  JTextArea logfield = new JTextArea();
    public  JScrollPane logfieldpane = new JScrollPane(logfield,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public int noofhearts1 = 0;
    public int totalpoints1 = 0;
    public int noofhearts2 = 0;
    public int totalpoints2 = 0;
    
    public JLabel noofheartslabel;
    public JLabel totalpointslabel;
    public JLabel noofheartslabel2;
    public JLabel totalpointslabel2;
    public int dealbuttonpressed=0;
    public boolean showhandbuttonpressed1=false;
    public boolean showhandbuttonpressed2=false;
    
    public Gui(HeartsDealer dealer, HeartsPlayer player1, HeartsPlayer player2) {
        dealbuttonpressed=0;
        
     noofheartslabel=new JLabel("Number Of Hearts: "+String.valueOf(player1.getTotalhearts()));
     totalpointslabel=new JLabel("Total Points: "+String.valueOf(player1.getTotalscore()));
    noofheartslabel2=new JLabel("Number Of Hearts: "+String.valueOf(player2.getTotalhearts()));
    totalpointslabel2=new JLabel("Total Points: "+String.valueOf(player2.getTotalscore()));
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250,570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        deckdeckcards.setLayout(new GridLayout(9,6));
        logfield = dealer.getLog();
        logfield.setEditable(false);

        JScrollPane dealermaster = new JScrollPane(logfield,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel dealertotal = new JPanel();
        dealertotal.setLayout(new GridLayout(2,0,1,1));
        dealertotal.add(deckdeckcards2);
        dealertotal.add(dealermaster);
        this.dealer=dealer;
        this.player1=player1;
        this.player2=player2;
        deckdeckcards2.setPreferredSize(new Dimension(900, 800));
        deckdeckcards.setPreferredSize(new Dimension(900, 800));
        dealer.shuffleCards();
       
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.ipady = 0;
        
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weighty = 1.0; 
        c.weightx = 1.0; 
        //c.fill = GridBagConstraints.HORIZONTAL;
        JLabel labeltest2 = new JLabel("Test2");
        JLabel labeltest3 = new JLabel("Test3");
        JLabel labeltest4 = new JLabel("Test");
        JLabel labeltest5 = new JLabel("Test2");
        JLabel labeltest6 = new JLabel("Test3");

          createdealerpanel();
        createplayer1panel();
        player1winpanel();
                   createplayer2panel();
             player2winpanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);
        this.add(player1panel,c);
        this.deck1cards=deck1cards;
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(deck1cards.getDeckpanel(),c);
        c.gridx++;
        c.gridheight=1;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        
        this.add(player1winninginfo,c);
        c.gridwidth=1;
        c.ipadx=0;
        c.gridx=0;
        c.gridy++;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx=1.0;
        c.weighty=1.0;
        
      
        this.add(dealerpanel,c);
        c.gridx++;
        
        c.gridheight=2;
        c.ipady=160;
        c.ipadx=20;
        c.gridwidth=3;
        this.add(dealertotal,c);
        c.gridy++;
        c.gridx=0;
        c.ipady=0;
        c.ipadx=0;
        c.gridwidth=1;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        
       
        c.insets = new Insets(0,0,40,0);
        this.add(player2panel,c); 
        c.gridx++;
        
        this.deck2cards=deck2cards;
        c.insets = new Insets(0,0,20,0);
        this.add(deck2cards.getDeckpanel(),c);
        c.gridx++;
      
        this.add(player2winninginfo,c);
        //deckdeckcards.setVisible(true);
        this.setVisible(true);
        
        /*this.dealer=dealer;
        this.player1=player1;
        this.player2=player2;
        deckdeckcards2.setPreferredSize(new Dimension(900, 800));
        deckdeckcards.setPreferredSize(new Dimension(900, 800));

             dealer.shuffleCards();
       deckdeckcards.setLayout(new GridLayout(9,6,3,3));
        JLabel labeltest = new JLabel("Test");
        JLabel labeltest2 = new JLabel("Test2");
        JLabel labeltest3 = new JLabel("Test3");
        JLabel labeltest4 = new JLabel("Test");
        JLabel labeltest5 = new JLabel("Test2");
        JLabel labeltest6 = new JLabel("Test3");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250,430);
        this.setLayout(new GridLayout(3, 3, 1, 1));
        this.setLocationRelativeTo(null);
        createplayer1panel();
        this.add(player1panel);
        this.deck1cards=deck1cards;

        this.add(deck1cards.getDeckpanel());
        this.add(labeltest2);
        createdealerpanel();
        this.add(dealerpanel);
        this.add(deckdeckcards2);
        this.add(labeltest4); 
        createplayer2panel(); 
       
        this.add(player2panel); 
        this.deck2cards=deck2cards;
        this.add(deck2cards.getDeckpanel());
        this.add(labeltest6);
        deckdeckcards.setVisible(true);
        this.setVisible(true);
*/
    }
    public void createplayer1panel()
    {

       player1panel.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
        c.gridy=0;
        c.gridx=0;
        c.anchor=GridBagConstraints.PAGE_START;
        c.weightx=1.0;
        c.weighty=1.0;
        c.ipadx=2;
        c.gridwidth=2;
        c.fill=GridBagConstraints.VERTICAL;
        JLabel playerlabel = new JLabel("Player 1");
        player1panel.add(playerlabel,c);
        c.ipadx=1;
        c.ipady=1;
        c.gridwidth=1;
        c.gridheight=1;
        c.fill=GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx=1.0;
        c.weighty=1.0;
        c.insets = new Insets(40, 10, 5, 5);
        JButton showinfobutton = new JButton("Introduce");
        showinfobutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                  logfield.setText(logfield.getText() + "Hey im " + player1.getName() + " " +player1.getSurname() + ", im "+ player1.getAge() + " years old and im playing as player 1\n");
                 // restart();
                 }
              });
        c.gridy++;
    
        player1panel.add(showinfobutton,c);
        c.gridx++;
        c.weightx=1.0;
        JButton showdeckbutton = new JButton("Show Hand");
        showdeckbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.println(dealbuttonpressed);
                    if(dealbuttonpressed==5)
                    {
                   deck1cards.showhandcards();
                  showhandbuttonpressed1=true;
                    }
                    else
                    {
                    logfield.setText(logfield.getText()+"Dealer:Player 1,you cannot show your hand.Please wait to get 5 cards in total!\n");
                    }
                    
                    }
              });
        player1panel.add(showdeckbutton,c);

        player1panel.setVisible(true);
    }
    
    public void createdealerpanel()
    {
       dealerpanel.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.gridy=0;
       c.gridx=0;
       //c.weightx=1.0;
        
       c.anchor=GridBagConstraints.PAGE_START;
       c.weighty=1.0;
       c.weightx=1.0;
       c.gridwidth=2;
       c.fill=GridBagConstraints.VERTICAL;
       JLabel dealerlabel = new JLabel("Dealer");
       dealerpanel.add(dealerlabel,c);
       c.ipadx=1;
       c.ipady=30;
       c.gridwidth=1;
       c.gridheight=1;//na thimamai oti to ipad megalwnei ta component eno to grid ta periorizei
       c.fill=GridBagConstraints.HORIZONTAL;
       JButton introducebutton = new JButton("Introduce");
       introducebutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                  logfield.setText(logfield.getText() + "Hey im " + dealer.getName() + " " +dealer.getSurname() + ", im "+ dealer.getAge() + " years old and im the dealer of this game,i will guide and assist you for the rest of the game\n");
                 
                 }
              });
        c.gridy++;
        dealerpanel.add(introducebutton,c);
        JButton showdeckbutton = new JButton("Show Deck");
        showdeckbutton.addActionListener(new ActionListener()
             {
                 
                public void actionPerformed(ActionEvent e) 
                {
                deckdeckcards.removeAll();
                 
                 GuiShowDeckDealer deal1 = new GuiShowDeckDealer(player1.getHand(),player2.getHand(),dealer.getDeckDealer().getDeck());
                 BufferedImage myPicture;
                 for(JLabel card:deal1.getCards())
                    {
                         try {
            myPicture = ImageIO.read(new File(card.getText()));
            Image dimg=myPicture.getScaledInstance(60, 85,
        Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(dimg));
         
           deckdeckcards.add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
                    }
        dealer.shuffleCards();

        deckdeckcards.invalidate();
        deckdeckcards.validate();
        deckdeckcards.repaint();
        deckdeckcards2.invalidate();
        deckdeckcards2.validate();
        deckdeckcards2.repaint();
        deckdeckcards2.setVisible(true);
                 }
              });
        c.gridx++;
        dealerpanel.add(showdeckbutton,c);
        JButton dealbutton = new JButton("Deal");
        dealbutton.putClientProperty("dealer", dealer);
        dealbutton.putClientProperty("player1", player1);
        dealbutton.putClientProperty("player2", player2);
        dealbutton.putClientProperty("deck1", deck1cards);
        dealbutton.putClientProperty("deck2", deck2cards);
        dealbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    HeartsDealer dealer=(HeartsDealer)((JButton)e.getSource()).getClientProperty( "dealer" );
                    HeartsPlayer player1 = (HeartsPlayer)((JButton)e.getSource()).getClientProperty( "player1" );
                    HeartsPlayer player2 = (HeartsPlayer)((JButton)e.getSource()).getClientProperty( "player2" );
                    GuiPlayerDeck deck1cards = (GuiPlayerDeck)((JButton)e.getSource()).getClientProperty( "deck1" );
                    GuiPlayerDeck deck2cards = (GuiPlayerDeck)((JButton)e.getSource()).getClientProperty( "deck2" );
                    dealer.dealToPlayers(player1, player2);
                    JLabel label1= new JLabel(player1.getHand().get(player1.getHand().size()-1).toString());
                    JLabel label2= new JLabel(player2.getHand().get(player2.getHand().size()-1).toString());
                  if(dealbuttonpressed<5)
                  {
                    if(dealer.getRound()<=5)
                    {
                    deck1cards.setDeckcard(label1);
                    deck2cards.setDeckcard(label2);
                    dealbuttonpressed++;
                    }
                    else
                    {
                        logfield.setText(logfield.getText()+"Dealer:I cannot deal anymore since 5 rounds have passed!\n");
                    }
                  }
                  else
                  {
                      logfield.setText(logfield.getText()+"Dealer:I allready gave 5 cards to you gentlemen. Please show hands now to decide whos the winner of this round\n");
                   
                  }
                 }
              });
        
        c.gridx--;
        c.gridy++;
        dealerpanel.add(dealbutton,c);
        JButton decidewinnerbutton = new JButton("Decide Winner");
        decidewinnerbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                        if(showhandbuttonpressed1 && showhandbuttonpressed2)
                        {
                    dealer.decideWinner(player1, player2);

                   noofheartslabel.setText("Number Of Hearts: "+String.valueOf(player1.getTotalhearts()));
                   noofheartslabel2.setText("Number Of Hearts: "+String.valueOf(player2.getTotalhearts()));
                   totalpointslabel.setText("Total Points: "+String.valueOf(player1.getTotalscore()));
                   totalpointslabel2.setText("Total Points: "+String.valueOf(player2.getTotalscore()));
                   logfield.setText(logfield.getText()+"Dealer: Round["+String.valueOf(dealer.getRound())+"]\n");
                   dealer.setLog(logfield);
                   dealer.setRound(dealer.getRound()+1);
                   HeartsPlayer winner = new HeartsPlayer();
                   if(player1.getTotalscore()>player2.getTotalscore())
                   {
                        winner = player1;
                       logfield.setText(logfield.getText()+"Dealer:Player 1 ["+player1.getName() +" "+ player1.getSurname()+"] won the round\n");
                   }
                   else if(player2.getTotalscore()>player1.getTotalscore())
                   {
                        winner = player2;
                   logfield.setText(logfield.getText()+"Dealer:Player 2 ["+player2.getName() +" "+ player2.getSurname()+"] won the round\n");
                      
                   }
                   else
                   {
                       logfield.setText(logfield.getText()+"Dealer:We have a draw,none of you won\n");
                      
                   }
                   
                   if(dealer.getRound()<=6)
                   {
                      
                            restart();
                    
                      
                   }
                   else
                   {
                       logfield.setText(logfield.getText()+"Dealer:This was the Last Round  final winner is "+winner.getName()+winner.getSurname()+"\n");
                   }
                }
                         else
                       {
                           logfield.setText(logfield.getText()+"Dealer:Both of you must show hands to decide who's the winner!\n");
                       }
                }
                
              });
        
        c.gridx++;
       
        dealerpanel.add(decidewinnerbutton,c);
        introducebutton.setPreferredSize(decidewinnerbutton.getPreferredSize());
        showdeckbutton.setPreferredSize(decidewinnerbutton.getPreferredSize());
        dealbutton.setPreferredSize(decidewinnerbutton.getPreferredSize());
        dealerpanel.setVisible(true);
    }
    
      public void createplayer2panel()
    {
      
       player2panel.setLayout(new GridBagLayout());
       //player1panel.setPreferredSize(new Dimension(250, 200));
       GridBagConstraints c = new GridBagConstraints();
        c.gridy=0;
        c.gridx++;
       //c.weightx=1.0;
        c.weighty=1.0;
        c.anchor=GridBagConstraints.NORTH;
        c.ipadx=2;
        c.ipady=2;
        
        c.gridwidth=2;
        c.fill=GridBagConstraints.VERTICAL;
        
        
        JLabel playerlabel = new JLabel("Player 2");
        player2panel.add(playerlabel,c);
        c.ipadx=1;
        c.ipady=1;
        c.gridwidth=1;
        c.gridheight=1;
        c.fill=GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx=1.0;
        c.weighty=1.0;
        c.insets = new Insets(40, 10, 5, 5);
        
        JButton showinfobutton = new JButton("Introduce");
        showinfobutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                   logfield.setText(logfield.getText() + "Hey im " + player2.getName() + " " +player2.getSurname() + ", im "+ player2.getAge() + " years old and im playing as player 2\n");
                 }
              });
        c.gridy++;
        player2panel.add(showinfobutton,c);
        c.gridx++;
        JButton showdeckbutton = new JButton("Show Hand");
        showdeckbutton.addActionListener(new ActionListener()
             {
                public void actionPerformed(ActionEvent e) 
                {
                    if(dealbuttonpressed==5)
                    {
                   deck2cards.showhandcards();
                    showhandbuttonpressed2=true;
                    }
                    else
                    {
                        logfield.setText(logfield.getText()+"Dealer:Player 2,you cannot show your hand.Please wait to get 5 cards in total!\n");
                    }
                 }
              });
        player2panel.add(showdeckbutton,c);
       
        
        player2panel.setVisible(true);
        
    }
   public void player1winpanel()
   {
       player1winninginfo.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.gridx=0;
       c.gridy=0;
       c.anchor = GridBagConstraints.CENTER;
       c.weightx=1.0;
       c.weighty=1.0;
       c.insets = new Insets(30,0,0,0);
       player1winninginfo.add(noofheartslabel,c);
       c.gridy++;
       c.insets = new Insets(10,0,0,0);
       
       player1winninginfo.add(totalpointslabel,c);
       player1winninginfo.setVisible(true);
      
       
   }
   
      public void player2winpanel()
   {
       player2winninginfo.setLayout(new GridBagLayout());
       GridBagConstraints c = new GridBagConstraints();
       c.gridx=0;
       c.gridy=0;
       c.anchor = GridBagConstraints.CENTER;
       c.weightx=1.0;
       c.weighty=1.0;
       c.insets = new Insets(0,0,0,0);
       player2winninginfo.add(noofheartslabel2,c);
       c.gridy++;
       c.insets = new Insets(10,0,40,0);
       
       player2winninginfo.add(totalpointslabel2,c);
       player2winninginfo.setVisible(true);
      
       
   }
   
     public void restart()
    {
        getContentPane().removeAll();
        Gui gui1= new Gui(dealer,player1,player2);
        gui1.setLocation(this.getLocation());
        revalidate();
        repaint();
        this.dispose();
    }
    
    
}
