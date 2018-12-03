package DeckOfCards;

import java.util.ArrayList;

public class Hand extends Card {

	public Hand(Rank rank, Suit suit) {
		super(rank, suit);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Card> cards = new ArrayList<Card>();

	public void addCard(Card card) {
		cards.add(card);
	}

	public int score() {
		int score = 0;
		for (Card card : cards) {
			score += card.getRankValue();
		}
		return score;
	}

	public String showHand() {
		String str = "";
		for (Card c : cards) {
			str += c.toString() + " \n";
		}
		return str;
	}

}
