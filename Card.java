//Jake Thweat
//CS 11

/*
  Program creates an array of cards to represent a deck. An object of type Card 
  represents a playing card. The card has a suit, which can be spades, hearts, 
  diamonds, or clubs. 
*/
public class Card
{
   
   public final static int SPADES = 1;   // The 4 suits
   public final static int HEARTS = 2;
   public final static int DIAMONDS = 3;
   public final static int CLUBS = 4;
   
   public final static int ACE = 1;      // Face card's values
   public final static int JACK = 11;    
   public final static int QUEEN = 12;   
   public final static int KING = 13;
   
   /*
     This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
     CLUBS.
   */
   private final int SUIT; 
   
   /*
     The card's rank.
   */
   private final int RANK;
   
   /*
      Creates a card with a specified suit and rank.
      @param rank the rank of the new card.  
      @param suit the suit of the new card.
      @throws IllegalArgumentException if the parameter values are not in appropriate range
   */
   public Card(int rank, int suit) {
      if (suit != SPADES && suit != HEARTS && suit != DIAMONDS && 
            suit != CLUBS)
         throw new IllegalArgumentException("Illegal playing card suit");
      RANK = rank;
      SUIT = suit;
   }

   /*
     Returns the suit of the card.
     @returns the suit of the card.
   */
   public int getSuit() {
      return SUIT;
   }
   
   /*
     Returns the rank of the card.
     @return the rank.
   */
   public int getRank() {
      return RANK;
   }
   
   /*
     Returns a String representation of the card's suit.
     @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs".
   */
   public String suitToString() {
      switch(SUIT)
      {
         case SPADES:
            return "Spades";
         case HEARTS:
            return "Hearts";
         case DIAMONDS:
            return "Diamonds";
         case CLUBS:
            return "Clubs";
         default:
            return "Unknown";
      }
   }
   
   /*
     Returns a String representation of the card's rank.
     @return for a regular card, one of the strings "Ace", "2",
     "3", ..., "10", "Jack", "Queen", or "King".  
  */
   public String rankToString() 
   {
      switch(RANK)
      {
         case 1:   return "Ace";
         case 2:   return "2";
         case 3:   return "3";
         case 4:   return "4";
         case 5:   return "5";
         case 6:   return "6";
         case 7:   return "7";
         case 8:   return "8";
         case 9:   return "9";
         case 10:  return "10";
         case 11:  return "Jack";
         case 12:  return "Queen";
         default:  return "King";
      }
   }
   
   /*
     Returns a string representation of this card, including both
     its suit and its rank.
   */
   public String toString()
   {
      return rankToString() + " of " + suitToString();
   }
   
}