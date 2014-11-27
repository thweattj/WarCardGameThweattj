
public class CardImage
{
   public final int RANK;
   public final int SUIT;
   
   public CardImage(Card card)
   {
      RANK = card.getRank();
      SUIT = card.getSuit();
   }
   
   public String getImage()
   {
      String firstR = String.valueOf(RANK.charAt(0).toLowerCase());
      return firstR;
   }
}
      
      