public class BlackJackCard extends Card
{
  	//constructors



  	public BlackJackCard(int value, String suit) {
  		super(value, suit);
		
	}

	public BlackJackCard() {
		super();
		
	}


	public int getValue()
  	{
  		if (super.getValue() > 10)
  			return 10;

		return super.getValue();
  	}
  	
 }