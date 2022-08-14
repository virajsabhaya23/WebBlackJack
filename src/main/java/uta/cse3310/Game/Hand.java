package uta.cse3310.Game;

import java.util.ArrayList;

public class Hand {

    public void addCard(Card card) {
        hand.add(card);
    }

    public void discardCard(Card card) {
        hand.remove(card);
    }

    public ArrayList<Card> hand = new ArrayList<Card>();
    public int hand_val;
}