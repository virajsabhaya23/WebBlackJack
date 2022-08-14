package uta.cse3310;

import org.junit.Before;
import org.junit.Test;
import uta.cse3310.Game.*;
import uta.cse3310.Game.Dealer;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealerUnderTest;

    @Before
    public void setUp() 
    {
        dealerUnderTest = new Dealer("name", 0);
    }

    @Test
    public void testInitializeCards() {
        // Setup
        // Run the test
        dealerUnderTest.initializeCards();
        int total = 0;

        for(int i = 0; i < dealerUnderTest.hand.hand.size(); i++)
        {
            total+=dealerUnderTest.hand.hand.get(i).getValue();
        }

        // Verify the results
        assertEquals(dealerUnderTest.hand.hand_val, total);

    }

    @Test
    public void testDealCard() {
        // Setup
        final Hand player = new Hand();

        // Run the test
        dealerUnderTest.dealCard(player);



        // Verify the results
    }

    @Test
    public void testTakeBet() {
        // Setup
         final Player player = new Player("name");
         final int balance = player.balance;
         boolean result;
 
         // Run the test
         while(player.busted == false)
         {
             Options.hit(dealerUnderTest, player);
             Check.bust(dealerUnderTest, player);
         }
 
         if(balance > player.balance)
         {
             result = true;
         }
         else
         {
             result = false;
         }
 
         // Verify the results
         assertEquals(player.busted, result);
    }

    @Test
    public void testWinBet() {
        // Setup
        final Player player = new Player("name");
        final int balance = player.balance;
        boolean result;

        // Run the test
        while(player.busted == false)
        {
            Options.hit(dealerUnderTest, player);
            Check.bust(dealerUnderTest, player);
        }

        if(balance < player.balance)
        {
            result = true;
        }
        else
        {
            result = false;
        }

        // Verify the results
        assertEquals(player.busted, result);
    }
}
