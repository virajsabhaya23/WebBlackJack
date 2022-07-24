package uta.cse3310.Game;

import uta.cse3310.Game.Dealer;

public class Check {
    public int check_val(Dealer dealer, Player player) {
        int val = 0;
        for (Card c : player.hand.hand) {
            val += c.getValue();
        }
        if (val > 21) {
            bust(dealer, player);
        }
        return val;
    }

    public void bust(Dealer dealer, Player player) {
        dealer.takeBet(player);
        player.busted = true;
    }

    public void win(Dealer dealer, Player player) {
        dealer.winBet(player);
        player.busted = true;

    }
}
