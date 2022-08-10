
package uta.cse3310;

import uta.cse3310.Game.*;
import uta.cse3310.Game.Check;

public class Options {
    public static void hit(Dealer dealer, Player player) {
        dealer.dealCard(player.hand);
        player.round = false;
    }

    public static void doubledown(Dealer dealer, Player player) {
        player.round = false;
        dealer.dealCard(player.hand);
        Check.doubled(dealer, player);
    }

    public static void stand(Player player) {
        player.round = false;
    }

    public static void split(Player player) {
        player.round = false;
    }
}