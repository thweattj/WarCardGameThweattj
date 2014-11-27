//Jake Thweatt
//CS 110

import java.util.ArrayList;

public class WarCardPlayer extends CardPlayer
{
   public ArrayList<Card> pile;
   public int curCardRank;
   public int curCardSuit;
   
   /*
      Constructor
      @params playerNum The number of the player
   */
   public WarCardPlayer(int playerNum)
   {
      super(playerNum);
      pile = new ArrayList<Card>();
   }
   
   /*
      play method plays the next card in the deck and sets the
      current card values (rank and suit) to that card.
      @return The card played
   */
   public Card play()
   {
      Card card = super.play();
      curCardRank = card.getRank();
      curCardSuit = card.getSuit();
      return card;
   }

   /*
      getPilseSize method returns the size of the player's pile
      @return The integer size of the player's pile.
   */
   public int getPileSize()
   {
      return pile.size();
   }
   
   
   public boolean war(WarCardPlayer other)
   {
      if (curCardRank==other.curCardRank)
         return true;
      else
         return false;
   }
}