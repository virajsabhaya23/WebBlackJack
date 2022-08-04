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
import uta.cse3310.Game.Check;

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
                int in;
                boolean play = true;
                Dealer dealer = new Dealer("Dealer", num);
                dealer.initializeCards();
                Player player = new Player("P1");
                for (int j = 0; j < 2; j++) {
                        dealer.dealCard(player.hand);

                }
                dealer.dealCard(dealer.hand);
                while (play == true) {
                        Scanner scn = new Scanner(System.in);

                        while (player.busted == false) {

                                player.round = true;

                                Check.count(player, dealer);

                                while (player.round == true) {
                                        Check.print_cards(dealer, player);
                                        // System.out.println("\n////////////////////////////////////////////\n");
                                        System.out.println("1) Hit\n2) Stand\n3) DoubleDown\n4) Split");
                                        in = scn.nextInt();

                                        if (in == 1) {
                                                Options.hit(dealer, player);
                                        } else if (in == 2) {
                                                Options.stand(player);
                                        } else if (in == 3) {
                                                Options.doubledown(player);
                                        } else if (in == 4) {
                                                Options.split(player);
                                        }
                                        Check.count(player, dealer);

                                        Check.check_val(dealer, player);

                                        // Gson gson = new Gson();
                                        // String json = gson.toJson(deck.hand.get(i));
                                        // String data = "{'suite': 'Hearts','number': 'Queen','value': 10 }";
                                        // System.out.print(data);
                                        // Gson.fromJson(data, Card.class);
                                }

                        }
                        System.out.println("\n1) Continue?\n2) Quit");
                        in = scn.nextInt();
                        if (in == 2) {
                                play = false;
                        }
                }
        }
}
