//Jake Thweatt
//CS110

import java.util.Random;

/**
  Program simulates a deck of cards, creating 
  a 52 card deck for a card game.
*/
public class Deck 
{
   /** 
     Number of cards in standard deck 
   */
   public final static int CARDS_IN_DECK = 52;
   private Card [] deck;
   private int count;
   
   /**
       Default Constructor a regular 52-card deck in an initially ordered order.  
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
            deck[count]=new Card(r,s);
           count ++;
         }
      }
   }
   
   /**
      Creates a new deck of specified size
      @param cards The size of the new deck
   */
   public void newDeck(int cards)
   {
      deck = new Card[cards];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[count]=new Card(r,s);
           count++;
         }
      }
   }

   /** 
      Remove and return the top Card on the Deck
      @return A reference to a Card that was top on the Deck
   */
   public Card dealCard()
   {
     count--;
      return deck[count];
   }
   /** 
      Return current number of Cards in Deck
      @return number of Cards in Deck
   */
   public int cardsRemaining()
   {  
      return count;
   }
   /** 
      Randomize the order of Cards in Deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i <count; i++)
      {
         randNum = r.nextInt(count);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /** 
      Determine if Deck is empty
      @return true if there are no more cards, false otherwise
   */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
}
