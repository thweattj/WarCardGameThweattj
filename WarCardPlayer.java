//Jake Thweatt
//CS 110

import java.util.ArrayList;

/**
   WarCardPlayer extends CardPlayer object to include a card pile,
   current rank and current suit of card for a game of WAR.
*/
public class WarCardPlayer extends CardPlayer
{
   /**
      The card pile of won cards in WAR
   */
   public ArrayList<Card> pile;
   
   /**
      The last played (most recent) card
   */
   public Card card;
   
   /**
      The rank of the current card
   */
   public int curCardRank;
   
   /**
      The suit of the current card
   */
   public int curCardSuit;
   
   /**
      Constructor
      @param playerNum The number of the player
   */
   public WarCardPlayer(int playerNum)
   {
      super(playerNum);
      pile = new ArrayList<Card>();
   }
   
   /**
      play method plays the next card in the deck and sets the
      current card values (rank and suit) to that card.
      @return The card played
   */
   public Card play()
   {
      card = super.play();
      curCardRank = card.getRank();
      curCardSuit = card.getSuit();
      return card;
   }

   /**
      getPilseSize method returns the size of the player's pile
      @return The integer size of the player's pile.
   */
   public int getPileSize()
   {
      return pile.size();
   }
   
   /**
      war method determines if there is a war or not
      @return true if there is a war, false otherwise.
   */
   public boolean war(WarCardPlayer other)
   {
      if (curCardRank==other.curCardRank)
         return true;
      else
         return false;
   }
   
}