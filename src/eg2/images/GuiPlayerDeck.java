package erg2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiPlayerDeck {
    public int i;
    public JLabel[] deckcard = new JLabel[5];
    public JPanel deckpanel = new JPanel();
    public GuiPlayerDeck()
    {
        deckpanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.weightx=0.5;
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
        this.deckcard[i].setText(deckcard.getText());
        i++;
    }

    public JPanel getDeckpanel() {
        return deckpanel;
    }

    public void setDeckpanel(JPanel deckpanel) {
        this.deckpanel = deckpanel;
    }
    
}
