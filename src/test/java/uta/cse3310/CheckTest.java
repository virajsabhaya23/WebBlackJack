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
        while(player.value < 21)
        {
            Options.hit(dealer, player);
        }
        
        final int result = player.value;

        // Verify the results
        assertEquals(Check.check_val(dealer, player), result);
    }

    @Test
    public void testBust() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");
        final int balance = player.balance;
        boolean result;

        // Run the test
        while(player.busted == false)
        {
            Options.hit(dealer, player);
            Check.bust(dealer, player);
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
    public void testWin() {
         // Setup
         final Dealer dealer = new Dealer("name", 0);
         final Player player = new Player("name");
         final int balance = player.balance;
         boolean result;
 
         // Run the test
         while(player.busted == false)
         {
             Options.hit(dealer, player);
             Check.bust(dealer, player);
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

    @Test
    public void testPrint_cards() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        
        // Run the test
        while(player.value < 21)
        {
            Options.hit(dealer, player);
        }
        
        final int result = player.value;
        Check.print_cards(dealer, player);

        // Verify the results
        assertEquals(Check.check_val(dealer, player), result);
    }

    @Test
    public void testCount() {
        // Setup
        final Dealer dealer = new Dealer("name", 0);
        final Player player = new Player("name");

        
        // Run the test
        while(player.value < 21)
        {
            Options.hit(dealer, player);
        }
        
        final int result = player.value;

        // Verify the results
        assertEquals(Check.check_val(dealer, player), result);
}
