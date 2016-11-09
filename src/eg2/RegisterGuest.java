/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg2;

/**
 *
 * @author 3oxic
 */
public class RegisterGuest {
    private boolean player1f;
    private boolean player2f;
    private boolean dealerf;
    public RegisterGuest()
    {
        this.player1f=true;
        this.player2f=false;
        this.dealerf=false;
    }

    public boolean isPlayer1f() {
        return player1f;
    }

    public void setPlayer1f(boolean player1f) {
        this.player1f = player1f;
    }

    public boolean isPlayer2f() {
        return player2f;
    }

    public void setPlayer2f(boolean player2f) {
        this.player2f = player2f;
    }

    public boolean isDealerf() {
        return dealerf;
    }

    public void setDealerf(boolean dealerf) {
        this.dealerf = dealerf;
    }
    
}
