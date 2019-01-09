
/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class Card{
    
    private Suit suit;
    private Rank rank;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;

    }
    @Override
    public String toString(){
        return "rank: " + rank + " " + "suit: " + suit;
    }
}

