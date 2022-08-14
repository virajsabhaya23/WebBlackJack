package uta.cse3310;

import org.junit.Before;
import org.junit.Test;

public class DealerTest {

    private Dealer dealerUnderTest;

    @Before
    public void setUp() {
        dealerUnderTest = new Dealer("name", 0);
    }

    @Test
    public void testInitializeCards() {
        // Setup
        // Run the test
        dealerUnderTest.initializeCards();

        // Verify the results
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

        // Run the test
        dealerUnderTest.takeBet(player);

        // Verify the results
    }

    @Test
    public void testWinBet() {
        // Setup
        final Player player = new Player("name");

        // Run the test
        dealerUnderTest.winBet(player);

        // Verify the results
    }
}
