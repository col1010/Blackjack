public class Dealer extends Player
{
	//define a deck of cards
	Deck dealerDeck;

	public Dealer() {
		dealerDeck = new Deck();
	}

	public void  shuffle()
	{
	   dealerDeck.shuffle();
	}

	public Card  deal(){
	   return dealerDeck.nextCard();
	}
	
	public int numCardsLeftInDeck()
	{
		return dealerDeck.numCardsLeft();
	}

	public void hit()
	{
	   addCardToHand(dealerDeck.nextCard());
    }
}




