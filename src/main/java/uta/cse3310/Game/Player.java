package uta.cse3310.Game;

public class Player {
    public Player(String name) {

        this.name = name;
        this.balance = 500;
        this.busted = false;
    }

    public void placeBet(Dealer dealer, Player player, int bet) {
        dealer.bet += bet;
        player.bet += bet;
        player.balance -= bet;
    }

    public Hand hand = new Hand();
    private String name;
    public int balance;
    public int bet;
    public boolean busted;
}