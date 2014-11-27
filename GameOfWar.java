//Jake Thweatt
//CS 110
//Program similates the card game War between 2 players
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;

public class GameOfWar extends JFrame
{
   public static void main(String [] args)
   {
      Scanner keyboard = new Scanner(System.in);
      boolean Continue = true;
      WarCardPlayer Player1 = new WarCardPlayer(1);
      WarCardPlayer Player2 = new WarCardPlayer(2);
      Card card1, card2,           //cards played in normal "battle"
           card12, card22,         //Additional face up cards for WAR
           downCard11, downCard12, downCard21, downCard22;   //additional cards played in a War (downCard11 is Player1's 1st extra face down card, etc...)
      
      
      while ((Continue==true)&&(!(Player1.deck.isEmpty()))&&(!(Player2.deck.isEmpty())))
      {
         card1 = Player1.play();
         card2 = Player2.play();
         System.out.println("Player 1 draws a(n): " + card1.toString());
         System.out.println("Player 2 draws a(n): " + card2.toString());
         if (Player1.curCardRank > Player2.curCardRank)
         {
            Player1.pile.add(card1);
            Player1.pile.add(card2);
         }
         else if (Player1.curCardRank < Player2.curCardRank)
         {
            Player2.pile.add(card1);
            Player2.pile.add(card2);
         }
         else
         {
            System.out.println("WAR!");
         
            downCard11 = Player1.play();   //player 1's face down card
            downCard12 = Player2.play();
            downCard21 = Player2.play();   //player 2's face down card
            downCard22 = Player2.play();
            
            card12 = Player1.play();     //player 1's first addition face up card. Has a total of 3 cards on the "field"
            card22 = Player2.play();
               
            System.out.println("Player 1 draws a(n): " + card12.toString());
            System.out.println("Player 2 draws a(n): " + card22.toString());
               
            if (Player1.curCardRank > Player2.curCardRank)
            {
               System.out.println("Player 1 wins: " + card1 + ", " + card2 + ", " + card12 + ", " + 
                                   card22 + ", " + downCard11 + ", " + downCard12 + ", " + downCard21 + ", " + downCard22);
               Player1.pile.add(card1);
               Player1.pile.add(card2);
               Player1.pile.add(card12);
               Player1.pile.add(card22);
               Player1.pile.add(downCard11);
               Player1.pile.add(downCard12);
               Player1.pile.add(downCard21);
               Player1.pile.add(downCard22);
            }
            else if (Player1.curCardRank < Player2.curCardRank)
            {
               System.out.println("Player 2 wins: " + card1 + ", " + card2 + ", " + card12 + ", " + 
                                   card22 + ", " + downCard11 + ", " + downCard12 + ", " + downCard21 + ", " + downCard22);
               Player2.pile.add(card1);
               Player2.pile.add(card2);
               Player2.pile.add(card12);
               Player2.pile.add(card22);
               Player2.pile.add(downCard11);
               Player2.pile.add(downCard12);
               Player2.pile.add(downCard21);
               Player2.pile.add(downCard22);
            }
         }
         
         System.out.print("Continue?: ");
         Continue = keyboard.nextBoolean();
      }
         
      System.out.println(Player1.getPileSize());
      System.out.println(Player2.getPileSize());
      
      System.out.println(Player1.deck.cardsRemaining());
      System.out.println(Player2.deck.cardsRemaining());  
      
      //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
      
      JFrame frame = new ForHomework("New Frame ...");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
   
   
