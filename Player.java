import java.util.*;

public class Player
{
   private ArrayList<Card> hand;
   private int winCount;

   public Player ()
   {
	   hand = new ArrayList<>();
   }

   public Player (int score)
   {
	   winCount = score;
	   hand = new ArrayList<>();
   }

   public void addCardToHand( Card temp )
   {
	   hand.add(temp);
   }

   public void resetHand( )
   {
	   hand.clear();
   }

   public  void setWinCount( int numwins )
   {
	   winCount = numwins;
   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
	  int handValue =  0;
	  for (int i = 0; i < hand.size(); i++) {
		  handValue += hand.get(i).getValue();
	  }
      return handValue;
   }

   public void hit(Card temp)
   {
	   hand.add(temp);
   }

   public String toString()
   {
	  String handString = "Current hand: \n";
	  for (int i = 0; i < hand.size(); i++) {
		  handString += "[" + hand.get(i) + "] \n";
	  }
	  handString += "{TOTAL VALUE = " + getHandValue() + "}";
      return handString;
   }
}