//Jake Thweatt
//CS 110

import java.util.ArrayList;

/**
   Card Player class simulates a generic player with a 
   deck of cards and with dealing capabilities.
*/
public class CardPlayer
{
   /**
      A standard deck of 52 cards
   */
   public Deck deck; //deck of 52 cards
   
   /**
      The number of the player (to differentiate between Player Objects)
   */
   public int Player;   //player number
   
   /**
      Constructor
      @param numPlayer the number of the player (first, second, etc...)
   */
   public CardPlayer(int numPlayer)
   {
      deck = new Deck();
      deck.shuffle();
      Player = numPlayer;
   }
   
   /**
      play method deals a card from the top of the
      player's deck
      @return The Card Object on the "top" of the
         player's deck.
   */
   public Card play()
   {
      Card card = deck.dealCard();
      return card;
   }
   
   /**
      toString method prints the player's number
         as a string.
   */
   public String toString()
   {
      return Integer.toString(Player);
   }
}