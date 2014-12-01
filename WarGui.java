//Jake Thweatt
//CS 110

/**
   Program simulates the card game WAR with GUI system set to display all appropriate
   cards based on: each player plays 1 card at a time, a WAR is determined by rank,
   and during a WAR each player plays 2 additional cards (1 face down, the other face up).
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WarGui extends JFrame
{
   /**  The color of the playing field (Dark Green)*/
   private final Color DARKGREEN = new Color(18,100,5);  //create new color: Dark Green
   /**  The game instance of WAR */
   private WarGame War;
   /** Game players */
   private WarCardPlayer player1, player2;
   private CardImage cardImage;
   private JPanel titlePanel, play1Panel, play2Panel, cardPanel, warPanel1, warPanel2;
   private JButton battleButton, endButton;
   private JLabel title, play1Title, play2Title, pileExitLabel, card1Image, card2Image,
           card12Image, card22Image, downCard1, downCard2, gameOver, winner;
//-------------------------------------------------------------------------------------
   /**
     Graphical interface 
   */
   public WarGui()
   {
      player1 = new WarCardPlayer(1);
      player2 = new WarCardPlayer(2);
      War = new WarGame(player1, player2); 
      cardImage = new CardImage();
      setLayout(new BorderLayout());
      //pileExitLabel = new JLabel("You currently have " + player1.getPileSize() + 
      //                " cards in your pile. Would you like to quit now?");
      downCard1 = new JLabel(new ImageIcon("back.jpg"));
      downCard2 = new JLabel(new ImageIcon("back.jpg"));
      
      getContentPane().setBackground(DARKGREEN); //set background to dark
      //Title panel
      titlePanel = new JPanel(new GridLayout(1,3));
      titlePanel.setBackground(DARKGREEN);
      //Player1 panel
      play1Panel = new JPanel();
      play1Panel.setLayout(new BoxLayout(play1Panel, BoxLayout.Y_AXIS));
      play1Panel.add(new JLabel(new ImageIcon("deck.jpg")));
      play1Panel.setBackground(DARKGREEN);
      //player2 panel
      play2Panel = new JPanel();
      play2Panel.add(new JLabel(new ImageIcon("deck2.jpg")));
      play2Panel.setBackground(DARKGREEN);
      //card panel
      cardPanel = new JPanel(new GridLayout(2,2));
      cardPanel.setBackground(DARKGREEN);
      //panel for WAR cards
      warPanel1 = new JPanel(new GridLayout(1,2));
      warPanel1.setBackground(DARKGREEN);
      warPanel2 = new JPanel(new GridLayout(1,2));
      warPanel2.setBackground(DARKGREEN);
      
      //Create the initial set up and look of the field
      play1Title = new JLabel("Player 1", SwingConstants.CENTER);
      play1Title.setFont(new Font("ARIAL", Font.BOLD, 16));
      play1Title.setForeground(Color.WHITE);
      
      titlePanel.add(play1Title);
      title = new JLabel("Jake's War Card Game", SwingConstants.CENTER);
      title.setFont(new Font("ARIAL", Font.BOLD, 24));
      title.setForeground(Color.WHITE);
      titlePanel.add(title);
      
      play2Title = new JLabel("Player 2", SwingConstants.CENTER);
      play2Title.setFont(new Font("ARIAL", Font.BOLD, 16));
      play2Title.setForeground(Color.WHITE);
      titlePanel.add(play2Title);
      //add all panels to frame
      add(titlePanel, BorderLayout.NORTH);
      add(play1Panel, BorderLayout.WEST);
      add(cardPanel, BorderLayout.CENTER);
      add(play2Panel, BorderLayout.EAST);
      
      //Create initial images of first played cards
      cardImage.setCard(War.card1);
      card1Image = new JLabel(new ImageIcon(cardImage.determineImage()));
      cardPanel.add(card1Image);
      cardImage.setCard(War.card2);
      card2Image = new JLabel(new ImageIcon(cardImage.determineImage()));
      cardPanel.add(card2Image);
      
   //----------------------------------------------------------------------   
      //determine if there is a WAR
      if (!(War.isWar()))
      {
         //If no WAR, cardPanel is blank
         battleButton = new JButton("BATTLE!");
         cardPanel.add(new JLabel());
         cardPanel.add(new JLabel());
      }
      else
      {
         //if WAR is declared, the additional cards are added to the fields
         War.war();
         battleButton = new JButton("WAR!");
         
         cardImage.setCard(War.card12);
         card12Image = new JLabel(new ImageIcon(cardImage.determineImage()));
         warPanel1.add(card12Image);
         warPanel1.add(downCard1);
         
         warPanel2.add(downCard2);
         cardImage.setCard(War.card22);
         card22Image = new JLabel(new ImageIcon(cardImage.determineImage()));
         //add additional cards to the field
         warPanel2.add(card22Image);
         cardPanel.add(warPanel1);
         cardPanel.add(warPanel2);
      }
      //Add Battle button and Exit button to field
      battleButton.addActionListener(new battleAction());
      add(battleButton, BorderLayout.SOUTH);
      endButton = new JButton("You currently have " + player1.getPileSize() + 
                     " cards in your pile. Would you like to quit now?");
      revalidate();
      endButton.addActionListener(new endAction());
      play1Panel.add(endButton);
   }
//----------------------------------------------------------------------------   
   
   /**
      ButtonListener for battleButton
      Every time the button is pressed, the cards are updated
      with each player's most current card with a label. If 
      either player runs out of cards, the button disappears
      (end of game);
   */
   class battleAction implements ActionListener
   {
      public void actionPerformed(ActionEvent battle)
      {
         endButton.setLabel("You currently have " + player1.getPileSize() + 
                      " cards in your pile. Would you like to quit now?");
         downCard1 = new JLabel(new ImageIcon("back.jpg"));
         downCard2 = new JLabel(new ImageIcon("back.jpg"));
         battleButton.setVisible(false);
         //While the players' decks aren't empty, determine the next set of cards, otherwise; end.
         if(!(player1.deck.isEmpty()) && (!(player2.deck.isEmpty())) && ((player1.getPileSize() + player2.getPileSize()) < (2*player1.deck.CARDS_IN_DECK)))
         {
            battleButton.setVisible(true);
            War.play();
            cardPanel.removeAll();
            cardImage.setCard(War.card1);
            card1Image = new JLabel(new ImageIcon(cardImage.determineImage()));
            cardPanel.add(card1Image);
               
            cardImage.setCard(War.card2);
            card2Image = new JLabel(new ImageIcon(cardImage.determineImage()));
            cardPanel.add(card2Image);
            
            //determine if there is a WAR
            if (!(War.isWar()))
            {
               cardPanel.add(new JLabel());
               cardPanel.add(new JLabel());
            }
            else
            {
               //play additional cards and display them in cardPanel
               War.war();
               warPanel1.removeAll();
               battleButton = new JButton("WAR!");
               cardImage.setCard(War.card12);
               card12Image = new JLabel(new ImageIcon(cardImage.determineImage()));
               warPanel1.add(card12Image);
               warPanel1.add(downCard1);
               
               warPanel2.removeAll();
               warPanel2.add(downCard2);
               cardImage.setCard(War.card22);
               card22Image = new JLabel(new ImageIcon(cardImage.determineImage()));
               warPanel2.add(card22Image);
               cardPanel.add(warPanel1);
               cardPanel.add(warPanel2);
            }
            
            cardPanel.revalidate();
         }
         else
         {  
            //If the game is over, disable the buttons
            battleButton.setVisible(false);
            endButton.setVisible(false);

            gameOver = new JLabel("GAME OVER", SwingConstants.CENTER);
            gameOver.setFont(new Font("ARIAL", Font.BOLD, 24));
            gameOver.setForeground(Color.RED);
            add(gameOver, BorderLayout.SOUTH);
            cardPanel.removeAll();
            revalidate();
            
            //Determine the winner through player pile size
            if (player1.getPileSize() > player2.getPileSize())
            {
               winner = new JLabel("You WON!  You had " + player1.getPileSize() + " in your pile." +
                                    " Player 2 had " + player2.getPileSize() + " in their pile.", SwingConstants.CENTER);
               winner.setFont(new Font("ARIAL", Font.BOLD, 18));
               winner.setForeground(Color.RED );
               cardPanel.add(winner);
            }
            else if (player1.getPileSize() < player2.getPileSize())
            {
               winner = new JLabel("You LOST!  Player 2 had " + player2.getPileSize() + " in their pile." +
                                    "  You had " + player1.getPileSize() + " in your pile.", SwingConstants.CENTER);
               winner.setFont(new Font("ARIAL", Font.BOLD, 18));
               winner.setForeground(Color.RED);
               cardPanel.add(winner);
            }
            else
            {
               winner = new JLabel("It's a TIE.  You had " + player1.getPileSize() + " in your pile.", SwingConstants.CENTER);
               winner.setFont(new Font("ARIAL", Font.BOLD, 18));
               winner.setForeground(Color.RED);
               cardPanel.add(winner);
            }
            //update the frame
            cardPanel.revalidate();
         }
      }
   }
//-------------------------------------------------------------------------------
   
   /**
      endAction button action that ends the program. This clears the center board
      and prints the players' score (pile size)
   */
   class endAction implements ActionListener
   {
      public void actionPerformed(ActionEvent end)
      {
         gameOver = new JLabel("GAME OVER", SwingConstants.CENTER);
         gameOver.setFont(new Font("ARIAL", Font.BOLD, 24));
         gameOver.setForeground(Color.RED);
         revalidate();
         add(gameOver, BorderLayout.SOUTH);
         cardPanel.removeAll();
         
         //Player 1 wins
         if (player1.getPileSize() > player2.getPileSize())
         {
            winner = new JLabel("You WON!  You had " + player1.getPileSize() + " in your pile." +
                                 "  Player 2 had " + player2.getPileSize() + " in their pile.", SwingConstants.CENTER);
            winner.setFont(new Font("ARIAL", Font.BOLD, 18));
            winner.setForeground(Color.RED);
            cardPanel.add(winner);
         }
         //Player 2 wins
         else if (player1.getPileSize() < player2.getPileSize())
         {
            winner = new JLabel("You LOST!  Player 2 had " + player2.getPileSize() + " in their pile." +
                                 "  You had " + player1.getPileSize() + " in your pile.", SwingConstants.CENTER);
            winner.setFont(new Font("ARIAL", Font.BOLD, 18));
            winner.setForeground(Color.RED);
            cardPanel.add(winner);
         }
         //A tie
         else
         {
            winner = new JLabel("It's a TIE.  You had " + player1.getPileSize() + " in your pile.", SwingConstants.CENTER);
            winner.setFont(new Font("ARIAL", Font.BOLD, 18));
            winner.setForeground(Color.RED);
            cardPanel.add(winner);
         }
         battleButton.setVisible(false);
         endButton.setVisible(false);
         cardPanel.revalidate();
      }
      
   }
}