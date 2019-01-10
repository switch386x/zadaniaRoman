import java.util.HashMap;
import java.util.Map;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class BlackJackDeck extends Deck {
    
    private Map<Card,Integer> values = new HashMap<>();
    
    public BlackJackDeck(){ 
        super();
        for (Card card : cards){
            if (card.isNumber()){
                values.put(card, card.getRankValue());
            }else if(card.isFace()){
                values.put(card, 10);
            }else{
                values.put(card, 1);
            }
        }
    }
   
    @Override
    public int getCardValue(Card card) {
        if (card.isAce()){
            return 1;
        } else{
            return values.get(card);
        }
    }
    
    public int getCardValue(Card card, int currentCount) {
        if (card.isAce() && currentCount <= 10) {
            return 11;
        } else {
            return getCardValue(card);
        }
    }

}

