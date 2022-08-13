
// This code is based upon, and derived from the this repository
//            https:/thub.com/TooTallNate/Java-WebSocket/tree/master/src/main/example

// http server include is a GPL licensed package from
//            http://www.freeutils.net/source/jlhttp/

/*
 * Copyright (c) 2010-2020 Nathan Rajlich
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 */

package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.util.ArrayList;

/**
 * A simple WebSocketServer implementation. Keeps track of a "chatroom".
 */
public class WebBlackJack extends WebSocketServer {

  int numPlayers;
  Game game;
  private Player player;

  public WebBlackJack(int port) throws UnknownHostException {
    super(new InetSocketAddress(port));
  }

  public WebBlackJack(InetSocketAddress address) {
    super(address);
  }

  public WebBlackJack(int port, Draft_6455 draft) {
    super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  public static void main(String[] args) throws InterruptedException, IOException {

    // Create and start the http server

    HttpServer H = new HttpServer(8080, "./html");
    H.start();
    // create and start the websocket server

    int port = 8880;

    WebBlackJack s = new WebBlackJack(port);
    s.start();
    System.out.println("WebPokerServer started on port: " + s.getPort());

    // Below code reads from stdin, making for a pleasant way to exit
    BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String in = sysin.readLine();
      s.broadcast(in);
      if (in.equals("exit")) {
        s.stop(1000);
        break;
      }
    }
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    game = new Game();
    System.out.println("Connection opened");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    numPlayers -= 1;
    
    broadcast(conn + " has closed");
    System.out.println(conn + " has closed");
  }



  @Override
  public void onMessage(WebSocket conn, String message) {
    Dealer dealer = new Dealer("Dealer", 1);
    System.out.println("onMessage received"+message);
    UserEvent.UserEventType event = game.processMessage(message);
    if(event == UserEvent.UserEventType.NAME){
      String name = game.getName(message);
      int totalMoney = game.getMoney(message);
      int moneyBetted = game.getBet(message);
      player = new Player(name);
      player.balance = totalMoney;
      player.placeBet(moneyBetted);
      System.out.println("A new player has joinned the game");
        
      broadcast("this is broadcast");
      game.addPlayer(player);
      
      dealer.initializeCards();
      dealer.dealCard(dealer.hand);

      for (int j = 0; j < 2; j++) 
      {
              dealer.dealCard(player.hand);
      }
      while (player.round == true) {
       // broadcast(Check.print_cards(dealer, player));
      }

    
    }

    if(event == UserEvent.UserEventType.HIT){
      Options.hit(dealer, player);
      System.out.println("player hit");
    }
    
    if(event == UserEvent.UserEventType.STAND){
      Options.stand(player);
      System.out.println("player stand");
    }
    if(event == UserEvent.UserEventType.DOULBEDOWN){
      Options.doubledown(dealer, player);
      System.out.println("player doubledown");
    }
    if(event == UserEvent.UserEventType.SPLIT){
      Options.split(player);
      System.out.println("player split");
    }

  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {

  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
    ex.printStackTrace();
    if (conn != null) {
    }
  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
    setConnectionLostTimeout(0);
    setConnectionLostTimeout(100);
  }

}