package uta.cse3310.Game;

public class Dealer extends Player
{
    public Hand decks;
    public Hand hand = new Hand();
    public int num_decks;
    public int balance;
    public int bet;
    public int value;
    public int ace;

    public Dealer(String name, int num) 
    {
        super(name);
        this.num_decks = num;
    }

    public void initializeCards() 
    {
        int j;
        Hand hand = new Hand();
        for (int i = 0; i < num_decks; i++) 
        {
            for (Suite s : Suite.values()) 
            {
                j = 2;
                for (Num n : Num.values()) 
                {
                    Card card = new Card(s, n, j);
                    hand.addCard(card);
                    j++;
                }
            }
        }
        decks = hand;
        for (Card c : decks.hand) 
        {
            if (c.getNumber() == Num.Jack || c.getNumber() == Num.Queen || c.getNumber() == Num.King) 
            {
                c.setValue(10);
            }
        }
    }

    public void dealCard(Hand player) 
    {
        int i = (int) (Math.random() * ((num_decks * (decks.hand.size())))) + 1;
        player.addCard(decks.hand.get(i));
        decks.discardCard(decks.hand.get(i));
    }

    public void placeBet(int bet) 
    {
        this.bet += bet;
        this.balance -= bet;
    }

    public void takeBet(Player player) 
    {
        this.balance += player.bet;
        this.bet -= player.bet;
        player.bet = 0;
    }

    public void winBet(Player player) 
    {
        this.bet -= player.bet;
        player.balance += ((player.bet) * 2);
        player.bet = 0;
    }

    

}