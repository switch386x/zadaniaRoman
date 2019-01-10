
/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class WarDeck extends Deck {

    @Override
    public int getCardValue(Card card) {
        return card.getRankValue();
    }

}
