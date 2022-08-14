package uta.cse3310.Game;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Check {
    public static int check_val(Dealer dealer, Player player) {

        if (dealer.value < 17) {
            dealer.dealCard(dealer.hand);
        }

        count(player, dealer);

        if (dealer.value > 21 && player.busted == false) {
            win(dealer, player);
            player.busted = true;
            print_cards(dealer, player);
            System.out.println("Dealer Bust, You Win!");
        }

        else if (player.value > 21) {
            bust(dealer, player);
            print_cards(dealer, player);
            System.out.println("You Lose");
            player.busted = true;
            return player.value;
        }

        else if (player.value == 21 && dealer.value == 21) {
            print_cards(dealer, player);
            System.out.println("Push");
            player.busted = true;
        }

        else if (player.value < 21 && dealer.value < 21) {
            print_cards(dealer, player);
            return player.value;
        }

        else if (player.value == 21 && dealer.value != 21) {
            win(dealer, player);
            player.busted = true;
            print_cards(dealer, player);
            System.out.println("BlackJack, You Win!");
        }

        else if (dealer.value == 21 && player.value != 21) {
            bust(dealer, player);
            player.busted = true;
            print_cards(dealer, player);
            System.out.println("Dealer BlackJack, You Lose!");
        }
        return player.value;
    }

    public static void bust(Dealer dealer, Player player) {
        dealer.takeBet(player);
        player.busted = true;
    }

    public static void win(Dealer dealer, Player player) {
        dealer.winBet(player);
        player.busted = true;

    }

    public static void print_cards(Dealer dealer, Player player) {
       // String results = "{\"dealer\":";
        
        System.out.println("Dealer Hand\n /////////////////////////////////////////////\n");

        for (int j = 0; j < dealer.hand.hand.size(); j++) {
            System.out.print(
                    dealer.hand.hand.get(j).getNumber() + " of " +
                            dealer.hand.hand.get(j).getSuite()
                            + "\n\n");
            

        }
        System.out.println("Value of Hand = " + dealer.value);
        System.out.println("\n////////////////////////////////////////////\n");

        System.out.println("Player Hand\n /////////////////////////////////////////////\n");

        for (int j = 0; j < player.hand.hand.size(); j++) {
            System.out.print(
                    player.hand.hand.get(j).getNumber() + " of " +
                            player.hand.hand.get(j).getSuite()
                            + "\n\n");

        }
        System.out.println("Value of Hand = " + player.value);
        System.out.println("\n////////////////////////////////////////////\n");
       // return results;
    }

    public static void count(Player player, Dealer dealer) {
        player.value = 0;
        player.ace = 0;

        for (Card c : player.hand.hand) {
            if (c.getValue() == 11) {
                player.ace += 1;
            }
            player.value += c.getValue();
        }

        for (int i = 0; i < player.ace; i++) {
            if (player.value > 21) {
                player.value -= 10;
            }
        }

        dealer.value = 0;
        dealer.ace = 0;
        for (Card d : dealer.hand.hand) {
            if (d.getValue() == 11) {
                dealer.ace += 1;
            }
            dealer.value = dealer.value + d.getValue();
        }

        for (int i = 0; i < dealer.ace; i++) {
            if (dealer.value > 21) {
                dealer.value -= 10;
            }
        }
    }
}