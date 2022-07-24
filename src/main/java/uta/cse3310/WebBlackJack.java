package uta.cse3310;

import java.util.*;
import java.util.ArrayList;
import java.lang.*;

import uta.cse3310.Game.Card;
import uta.cse3310.Game.Hand;
import uta.cse3310.Game.Dealer;
import uta.cse3310.Game.Suite;
import uta.cse3310.Game.Num;
import uta.cse3310.Game.Player;

import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class WebBlackJack {

    public static void main(String[] args) {

        final int num = 1;
        Dealer dealer = new Dealer("Dealer", num);
        dealer.initializeCards();

        Player player = new Player("P1");
        for (int j = 0; j < 5; j++) {
            dealer.dealCard(player.hand);
        }

        System.out.println("Player Hand\n /////////////////////////////////////////////\n");

        for (int j = 0; j < player.hand.hand.size(); j++) {
            System.out.print(
                    player.hand.hand.get(j).getValue() + " of " +
                            player.hand.hand.get(j).getSuite()
                            + " " + player.hand.hand.get(j).getNumber() + "\n\n");

        }
        System.out.println(
                "\n////////////////////////////////////////////////\n\nRemaining deck\n//////////////////////////////////////////////\n");

        for (int i = 0; i < dealer.decks.hand.size(); i++) {

            System.out.print(
                    dealer.decks.hand.get(i).getValue() + " of " +
                            dealer.decks.hand.get(i).getSuite()
                            + " " + dealer.decks.hand.get(i).getNumber() + "\n");

        }

        System.out.println("\n////////////////////////////////////////////\n");

        System.out.print(
                "\nPlayer balance: " + player.balance + "\n" +
                        "Player bet: " + player.bet + "\n" +
                        "Current pot: " + dealer.bet + "\n" +
                        "Total lost: " + dealer.balance + "\n\n");

        player.placeBet(dealer, player, 50);

        System.out.print(
                "Player balance: " + player.balance + "\n" +
                        "Player bet: " + player.bet + "\n" +
                        "Current pot: " + dealer.bet + "\n" +
                        "Total lost: " + dealer.balance + "\n\n");

        dealer.takeBet(player);

        System.out.println(
                "Player balance: " + player.balance + "\n" +
                        "Player bet: " + player.bet + "\n" +
                        "Current pot: " + dealer.bet + "\n" +
                        "Total lost: " + dealer.balance + "\n\n");

        // Gson gson = new Gson();
        // String json = gson.toJson(deck.hand.get(i));
        // String data = "{'suite': 'Hearts','number': 'Queen','value': 10 }";
        // System.out.print(data);
        // Gson.fromJson(data, Card.class);
    }

}
