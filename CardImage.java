
public class CardImage
{
   private String RANK;
   private String SUIT;
   public String imageName;
   
   
   /*
      Default Constructor take no parameters and defaults
      RANK to 1 and SUIT to "H" (Strings).
   */
   public CardImage()
   {
      RANK = "1";
      SUIT = "H";
   }
   
   /*
      Alternate Constructor takes a Card object to determine the string
      value of the Card's rank and suit
      @params card The Card object to determine the rank and suit of
   */
   public CardImage(Card card)
   {
      RANK = card.rankToString();
      SUIT = card.suitToString();
   }
   
   
   /*
      SetCard method sets a new card to determine rank
      and suit of for image.
      @params card The Card object to determine image of.
   */
   public void setCard(Card card)
   {
      RANK = card.rankToString();
      SUIT = card.suitToString();
   }
   /*
      getRankName method determines the first letter of the RANK
      string (used to determine image)
      @return String The letter of the rank
   */
   private String getRankName()
   {
      String firstR = String.valueOf(RANK.charAt(0)).toLowerCase();
      return firstR;
   }
   
   /*
      getSuitName method determines the first letter of the SUIT
      string (used to determine image)
      @return String The letter of the suit
   */
   private String getSuitName()
   {
      String firstS = String.valueOf(SUIT.charAt(0)).toLowerCase();
      return firstS;
   }
   
   /*
      determineImage method determines the image based on the 
      values from getSuitName and getRankName methods 
      @return String The name of the image file that will be used.
   */
   public String determineImage()
   {
      String R = this.getRankName();
      String S = this.getSuitName();
      
      imageName = R+S+".jpg";
      return imageName;
   } 
}
      
      