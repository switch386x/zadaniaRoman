package DeckOfCards;

public enum Suit {

	HEARTS("Hearts", 1), 
	SPADES("Spades", 2), 
	DIAMONDS("Diamonds", 3), 
	CLUBS("Clubs", 4);

	private int value;
	private String suitName;

	private Suit(String suitName, int value) {
		this.suitName = suitName;
		this.value = value;
	}

	public int getValueOfSuit() {
		return value;
	}

	public void setValue(int value) {
		this.value = value; // is this redundant code as the constructor already
							// does this?
	}

	public String getSuitName() {
		return suitName;
	}

	public void setSuit(String suit) {
		this.suitName = suit; // is this redundant code as the constructor
								// already does this?
	}

}
