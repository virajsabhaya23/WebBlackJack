package uta.cse3310;

import java.util.*;
import uta.cse3310.Game.Dealer;
import uta.cse3310.Game.Player;
import uta.cse3310.Game.Check;

/*import java.util.ArrayList;
import java.lang.*;
import uta.cse3310.Game.Suite;
import uta.cse3310.Game.Num;
import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;*/

public class WebBlackJack {
        public static void main(String[] args) 
        {
                final int num = 1;
                int in;
                boolean play = true;
                Scanner scn = new Scanner(System.in);

                //Gson gson = new Gson();
                //String json; //= gson.toJson(deck.hand.get(i))
                while (play == true) 
                {
                        Dealer dealer = new Dealer("Dealer", num);
                        Player player = new Player("P1");

                        System.out.print("How much money do you have: ");
                        player.balance = scn.nextInt();

                        System.out.print("How much do you want to bet: ");
                        player.placeBet(scn.nextInt());

                        dealer.initializeCards();
                        dealer.dealCard(dealer.hand);

                        for (int j = 0; j < 2; j++) 
                        {
                                dealer.dealCard(player.hand);
                        }

                        while (player.busted == false) 
                        {
                                player.round = true;
                                Check.count(player, dealer);

                                while (player.round == true) 
                                {
                                        Check.print_cards(dealer, player);
                                        System.out.println("Player Balance: " + player.balance + "\nPlayer Bet: " + player.bet + "\n\n");
                                        System.out.println("1) Hit\n2) Stand\n3) DoubleDown\n4) Split\n");
                                        in = scn.nextInt();

                                        switch(in)
                                        {
                                                case 1: Options.hit(dealer, player);
                                                        break;
                                                case 2: Options.stand(player);
                                                        break;
                                                case 3: Options.doubledown(dealer, player);
                                                        break;
                                                case 4: Options.split(player);
                                                        break;
                                                default:System.out.println("Default option - Hit"); 
                                                        Options.hit(dealer, player);
                                                        break;
                                        }
                                        Check.count(player, dealer);
                                        System.out.println("\n\nPlayer Balance: " + player.balance + "\nPlayer Bet: " + player.bet + "\n\n");
                                        Check.check_val(dealer, player);

                                        if(in == 3 && player.value < 21)
                                        {
                                                System.out.println("You Lose");
                                                player.busted = true;
                                        }
                                }

                        }
                        System.out.println("\n1) Continue?\n2) Quit");
                        in = scn.nextInt();
                        if(in == 1)
                        {
                                player.busted = false;
                        }
                        else if(in == 2) 
                        {
                                play = false;
                        }
                }
                scn.close();       
        }
}
