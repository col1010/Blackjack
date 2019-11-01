import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<>();
		topCardIndex = 0;
		
		
		//loop through suits
			//loop through faces
				//add in a new card
		for (int i = 0; i < NUMSUITS; i++) {
			for (int k = 1; k <= NUMFACES; k++) {
				stackOfCards.add(new Card(k, SUITS[i]));
				topCardIndex += 1;
			}
		}
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		//reset variables as needed
	}

   //accessors
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return stackOfCards.size();
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex-1);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}