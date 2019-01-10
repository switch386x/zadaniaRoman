
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
    
    
    public boolean isNumber(){
        return rank.getRankValue() < 11;
    }
    
    public boolean isFace(){
        return rank.getRankValue() >= 11 && rank.getRankValue() < 14;
    }
    
    public int getRankValue(){                    //wartosc wynikajaca z napisu na karcie, a nie z wartosci w kontekscie konkretnego typu gry
        return rank.getRankValue();
    }
    
    public boolean isAce(){
        return Rank.ACE == rank;
    }
    
    @Override
    public String toString(){
        return rank + " " + suit;
    }
}

