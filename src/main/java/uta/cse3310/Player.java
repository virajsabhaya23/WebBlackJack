package uta.cse3310;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player {
    int money, call;
    String Name;
    int betted = 0;
    boolean ready = false;
    boolean folded = false;
    boolean swapping = false;
    uta.cse3310.Card Cards[];
    String LastMessageToPlayer;


    public void setMoney(int dollars){
        money = dollars;
    }
    public Player(String name) {

        this.name = name;
        this.balance = 500;
        this.busted = false;
        this.round = true;
    }

    public void setName(){

    }

    public void placeBet(int bet) 
    {
        this.bet += bet;
        this.balance -= bet;
    }

    public String asJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public Hand hand = new Hand();
    private String name;
    public int balance;
    public int bet;
    public int value;
    public int ace;
    public int Id;
    public boolean busted;
    public boolean round;
}
