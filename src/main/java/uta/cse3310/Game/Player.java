package uta.cse3310.Game;

public class Player {
    public Player(String name) 
    {
        //this.name = name;
        this.balance = 500;
        this.busted = false;
        this.round = true;
    }

    public void placeBet(int bet) 
    {
        this.bet += bet;
        this.balance -= bet;
    }

    public Hand hand = new Hand();
    //private String name;
    public int balance;
    public int bet;
    public int value;
    public int ace;
    public boolean busted;
    public boolean round;
}