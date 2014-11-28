//Jake Thweatt
//CS 110 JAVA
// A card class which has functionality with that of  standard playing cards
 
public class Card 
{ 
   public final static int SPADES = 5;
   public final static int CLUBS = 6;
   public final static int HEARTS = 7;
   public final static int DIAMONDS = 8;
   public final static int ACE = 1;
   public final static int JACK = 2;
   public final static int QUEEN = 3;
   public final static int KING = 4;
   private int rank;
   private int suit;
   /**
   Constructor sets suit and rank.
   */
   public Card(int Suit, int Rank)
   {
      if ((suit<9) && (suit>4))
         suit = Suit;
      else
         suit = 5;
      if ((rank<5) && (rank>1))
         rank = Rank;
      else
         rank = 1;
   }
      
   /**
   @return suit Returns the suit of the card.
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
   @return rank Returns the rank of the card.
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
   @return numRank Returns the rank of the card as a string.
   */
   public String rankToString()
   {
     String numRank;
     switch (rank)
     {
        case 1: numRank = "Ace"; 
        break; 
        case 2: numRank = "Jack"; 
        break; 
        case 3: numRank = "Queen"; 
        break; 
        case 4: numRank = "King"; 
        break; 
        default: numRank = "Unknown";
     }
     return numRank;
   }
   
   /**
   @return numSuit Returns the suit of the card as a string.
   */
   public String suitToString()
   {
     String numSuit;
     switch (suit)
     {
        case 5: numSuit = "Spades"; 
        break; 
        case 6: numSuit = "Clubs"; 
        break; 
        case 7: numSuit = "Hearts"; 
        break; 
        case 8: numSuit = "Diamonds"; 
        break; 
        default: numSuit = "Unknown";
     }
     return numSuit;
   }
   
   /**
   @param otherCard The card wich the object card is compared to.
   @return boolean Returns the truthiness of whether the card
   equals the other card.
   */
   public boolean equals(Card otherCard)
   {
      if (this.getRank() == otherCard.getRank())
         return true;
      else
         return false;
   }
}