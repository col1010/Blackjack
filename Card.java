public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
	
	public Card(int value, String suit) {
		this.suit = suit;
		face = value;
	}
	public Card() {
	
	}


	// modifiers
  	// accessors

  	public int getValue() {
  		return face;
  	}
  	
  	public String getSuit() {
  		return suit;
  	}

	public boolean equals(Object obj) {
		return false;
	}

	public String toString()
	   {
	     return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	   }
  	
 }
