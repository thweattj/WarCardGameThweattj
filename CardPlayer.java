//Jake Thweatt
//CS 110

//Card Player class simulates a generic deck of cards with dealing capabilities


import java.util.ArrayList;

public class CardPlayer
{
   
   public Deck deck; //deck of 52 cards
   public int Player;   //player number
   
   public CardPlayer(int numPlayer)
   {
      deck = new Deck();
      deck.shuffle();
      Player = numPlayer;
   }
   
   public Card play()
   {
      Card card = deck.dealCard();
      return card;
   }
   
   public String toString()
   {
      return Integer.toString(Player);
   }
}