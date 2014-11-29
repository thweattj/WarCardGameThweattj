//Jake Thweatt
//CS 110
//Program similates the card game War between 2 players

/*
   WarGame class used with WarGui for War card game with 
   graphical interface
*/
public class WarGame
{
   public Card card1, card2, card12, card22, downCard1, downCard2;
   private WarCardPlayer player1, player2;
   
   /*
      WarGame constructor uses WarCardPlayer Objects for determining
      card values and winnings
      @params play1 Player one of the game (a WarCardPlayer Object)
      @params play2 Player two of the game (a WarCardPlayer Object)
   */
   public WarGame(WarCardPlayer play1, WarCardPlayer play2)
   {
      player1 = play1;
      player2 = play2;
      this.play();
   }
   
   /*
      play method plays a card from each player's hand
   */
   public void play()
   {
      card1 = player1.play();
      card2 = player2.play();
      this.winner();
   }
   
   /*
      getPlayer1Card gets the last card that Player 1 played
      @return The Card Object last played by Player 1
   */
   public Card getPlayer1Card()
   {
      return card1;
   }

   /*
      getPlayer2Card gets the last card that Player 2 played
      @return The Card Object last played by Player 1
   */
   public Card getPlayer2Card()
   {
      return card2;
   }
   
   /*
      winner method determines the winner of a hand
      based on last card played
      @return 1 if player 1 wins, -1 if player 2 wins.
   */
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
   
   /*
      war method simulates the actions taken when a war
      occurs (the extra cards played). Then the winner
      is determined
      @return 1 is player 1 won -1 is player 2 won
   */
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
   
   /*
      determineWarWinner method determines the winner 
      of a war.
      @return 1 is player 1 wins -1 is player 2 wins
   */
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
   
   /*
      isWar method determines if there is a war based
      on the last played card of player 1 and player 2
      @return boolean true if the result is a war.
   */
   public boolean isWar()
   {
      if (card1.rankToString().equals(card2.rankToString()))
         return true;
      else
         return false;
   }
}
   
   
