import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WarGui extends JFrame
{
   // public boolean
   private final int WINDOW_WIDTH = 1366;
   private final int WINDOW_HEIGHT = 728;
   private final Color DARKGREEN = new Color(18,100,5);  //create new color: Dark Green
   
   private WarGame War;
   private WarCardPlayer player1, player2;
   private CardImage cardImage;
   private JPanel play1Panel, play2Panel, cardPanel;
   private JButton battleButton;
   private JLabel title, pic, cardImage1, cardImage2;
   private JPanel panel, panelE, panelW, panelC, subPanelE, subPanelW, subPanelC;
   private ImageIcon front1, front2, front12, front22, back, deck1, deck2;

   
   public WarGui()
   {
      player1 = new WarCardPlayer(1);
      player2 = new WarCardPlayer(2);
      War = new WarGame(player1, player2); 
      cardImage = new CardImage();
      setLayout(new GridLayout(2,3));
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      play1Panel = new JPanel();
      play1Panel.add(new JLabel(new ImageIcon("deck.jpg")));
      play1Panel.setBackground(DARKGREEN);
      play2Panel = new JPanel();
      play2Panel.add(new JLabel(new ImageIcon("deck2.jpg")));
      play2Panel.setBackground(DARKGREEN);
      cardPanel = new JPanel(new GridLayout(2,2));
      cardPanel.setBackground(DARKGREEN);
      
      battleButton = new JButton("BATTLE!");
      
      title = new JLabel("Jake's War Card Game");
      title.setFont(new Font("ARIAL", Font.BOLD, 24));
      add(new JLabel("Player 1", SwingConstants.CENTER));
      add(title);
      add(new JLabel("Player 2", SwingConstants.CENTER));
      add(play1Panel);
      add(cardPanel);
      add(play2Panel);
      
      
      //////////////
      cardImage.setCard(player1.card);

      cardPanel.add(new JLabel(player1.card.toString(), new ImageIcon(cardImage.determineImage()), SwingConstants.CENTER));
      cardImage.setCard(player2.card);

      cardPanel.add(new JLabel(player2.card.toString(), new ImageIcon(cardImage.determineImage()), SwingConstants.CENTER));

            
      getContentPane().setBackground(DARKGREEN); //set background to dark
      battleButton.addActionListener(new ButtonListener());
      play1Panel.add(battleButton);
  
   }
   //class to handle button press
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(!(player1.deck.isEmpty()) && (!(player2.deck.isEmpty())))
         {
            War.play();
            cardPanel.removeAll();
            cardImage.setCard(player1.card);
            cardPanel.add(new JLabel(player1.card.toString(), new ImageIcon(cardImage.determineImage()), SwingConstants.CENTER));
            cardImage.setCard(player2.card);
            cardPanel.add(new JLabel(player2.card.toString(), new ImageIcon(cardImage.determineImage()), SwingConstants.CENTER));
            cardPanel.revalidate();
         }
         else
            battleButton.setVisible(false);
      }
   }
   
   
   public static void main(String []args)
   {

      JFrame frame = new WarGui();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}