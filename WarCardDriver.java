//Jake Thweatt
//CS 110;
import javax.swing.*;
public class WarCardDriver
{
   public static void main(String []args)
   {
      JFrame frame = new WarGui();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1280,720);
      frame.validate();
      frame.setVisible(true);
   }
}