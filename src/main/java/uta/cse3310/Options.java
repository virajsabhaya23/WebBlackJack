
package uta.cse3310;

import uta.cse3310.Game.*;

public class Options {
    public static void hit(Dealer dealer, Player player) {
        dealer.dealCard(player.hand);
        player.round = false;
    }

    public static void doubledown(Player player) {
        player.round = false;
    }

    public static void stand(Player player) {
        player.round = false;
    }

    public static void split(Player player) {
        player.round = false;
    }
}