//Jake Thweatt
//CS 110
//Program similates the card game War between 2 players


public class WarGame
{
   private Card card1, card2, card12, card22, downCard1, downCard2;
   private WarCardPlayer player1, player2;
   
   public WarGame(WarCardPlayer play1, WarCardPlayer play2)
   {
      player1 = play1;
      player2 = play2;
      card1 = player1.play();
      card2 = player2.play();
      this.winner();
   }
   
   public void play()
   {
      player1.play();
      player2.play();
      this.winner();
   }
   
   public Card getPlayer1Card()
   {
      
      return card1;
   }
   
   public Card getPlayer2Card()
   {
      
      return card2;
   }
   
   public int war()
   {
      downCard1 = player1.play();
      card12 = player1.play();
      downCard2 = player2.play();
      card22 = player2.play();
      int winner = this.determineWarWinner();
      
      if (winner == 1)
         return 1;
      else
         return -1;
   }

   public int winner()
   {
      
      if (player1.curCardRank > player2.curCardRank)
      {
         player1.pile.add(card1);
         player1.pile.add(card2);
         return 1;
      }
      else if (player1.curCardRank < player2.curCardRank)
      {
         player2.pile.add(card1);
         player2.pile.add(card2);
         return -1;
      }
      else
      {
         return this.war();
      }
      
   }
   
   private int determineWarWinner()
   {
      if (player1.curCardRank > player2.curCardRank)
      {
         player1.pile.add(card1);
         player1.pile.add(card2);
         player1.pile.add(downCard1);
         player1.pile.add(downCard2);
         player1.pile.add(card12);
         player1.pile.add(card22);
         return 1;
      }
      else
      {
         player2.pile.add(card1);
         player2.pile.add(card2);
         player2.pile.add(downCard1);
         player2.pile.add(downCard2);
         player2.pile.add(card12);
         player2.pile.add(card22);
         return -1;
      }
   }
   
   public static void main(String []args)
   {
      WarCardPlayer player1 = new WarCardPlayer(1);
      WarCardPlayer player2 = new WarCardPlayer(2);
      WarGame WAR = new WarGame(player1, player2);
      
      System.out.println(player1.curCardRank);
      System.out.println(player2.curCardRank);
      System.out.println(player1.getPileSize());
      System.out.println(player2.getPileSize() + "\n");
      
      while (player1.curCardRank != player2.curCardRank)
      {
         WAR.play();
         
         System.out.println(player1.curCardRank);
         System.out.println(player2.curCardRank);
         System.out.println(player1.getPileSize());
         System.out.println(player2.getPileSize() + "\n");
      }

   }
}
   
   
