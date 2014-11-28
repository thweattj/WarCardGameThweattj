//Jake Thweatt
//CS110

/**
  Program simulates a deck of cards, creating 
  a standard 52 card deck. 
 
 */

import java.util.Random;
public class Deck 
{
   /** 
     Number of cards in standard deck 
     @value #CARDS_IN_DECK
   **/
   public final static int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   private Card [] deck;
   /** Current number of Cards in Deck */
   private int ct;
   
   /**
       Constructs a regular 52-card deck in an initially ordered order.  
    */
   public Deck()
   {
      newDeck();
   }
   /**
      Create a new collection of 52 cards, in sorted order
    */
   public void newDeck()
   {
      deck = new Card[CARDS_IN_DECK];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct ++;
         }
      }
   }
   
   /*
      Creates a new deck of specified size
      @params cards The size of the new deck
   */
   public void newDeck(int cards)
   {
      deck = new Card[cards];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct++;
         }
      }
   }

   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
      ct--;
      return deck[ct];
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining()
   {  
      return ct;
   }
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }

   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
      deck.newDeck();
      System.out.println("************");
      i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());

   }
}
