package uta.cse3310;
import org.junit.Test;
import uta.cse3310.Game.*;

import static org.junit.Assert.assertEquals;

public class CheckTest {

    @Test
    public void testCheck_val() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        // Run the test
        final int result = Check.check_val(dealer, player);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testBust() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        // Run the test
        Check.bust(dealer, player);

        // Verify the results
    }

    @Test
    public void testWin() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        // Run the test
        Check.win(dealer, player);

        // Verify the results
    }

    @Test
    public void testPrint_cards() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        // Run the test
        Check.print_cards(dealer, player);

        // Verify the results
    }

    @Test
    public void testCount() {
        // Setup
        final Player player = new Player("name");
        final Dealer dealer = new Dealer("name", 0);

        // Run the test
        Check.count(player, dealer);

        // Verify the results
    }
}
