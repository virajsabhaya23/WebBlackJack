package uta.cse3310.Game;

import java.util.ArrayList;

import uta.cse3310.UserEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Random;

import uta.cse3310.UserEvent.UserEventType;

public class Game {
    int maxPlayers = 5;
    char quotesChar = '"';
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Card> deck = new ArrayList<Card>();
    String[] suites = {"HEARTS", "CLUBS", "DIAMONDS", "SPADES"};
    String[] values = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE","TEN", "JACK", "QUEEN", "KING"};
    int winner = 0;
    int pot = 0;
    int ante = 5;
    int call = 0;
    int round = 0; //Round id (o = 1st betting, 1 = drawing, 2 = final betting)
    int[] playersMoney;
    boolean started = false;
    int turn; // player ID that has the current turn


    public String getName(String info){
        JsonObject gson = new Gson().fromJson(info, JsonObject.class);
        String name = gson.get("name").toString();
        System.out.println(name+"has joinned ");
        return name;
    }
    public int getMoney(String info){
        JsonObject gson = new Gson().fromJson(info, JsonObject.class);
        double moneyS = gson.get("totalMoney").getAsDouble();
        int money = (int)moneyS;
        System.out.println(money+"is total money");
        return money;
    }

    public int getBet(String info){
        JsonObject gson = new Gson().fromJson(info, JsonObject.class);
        double moneyS = gson.get("moneyBet").getAsDouble();
        int money = (int)moneyS;
        System.out.println(money+"betted");
        return money;
    }

    public UserEvent.UserEventType processMessage(String msg) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        // take the string we just received, and turn it into a user event
        UserEvent event = gson.fromJson(msg, UserEvent.class);

        if (event.event == UserEventType.NAME) {
            System.out.println("event name in game");
        }

        return event.event;
    }

    public boolean addPlayer(Player p) {
        if(players.size() > maxPlayers){
            System.out.println("Too many players already");
            return false;
        }
        else{
            players.add(p);
            return true;
        }
    }

    public Game() {
        System.out.println("new game created");
    }

}
