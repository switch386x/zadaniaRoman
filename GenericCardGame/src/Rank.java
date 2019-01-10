
/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */
// enums are type-safe, so assignment of anything else other than predefined ENUM constants. Immutable by assumption. Constructor is private. uterable.


public enum Rank {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);
 
    private int rankValue;
    
    private Rank(int rankValue){
        this.rankValue = rankValue;
    }
    
    public int getRankValue() {
        return rankValue;
    }
    
    public Rank getRankByValue(int value){
        switch(value){
            case 2: return Rank.TWO;
            case 3: return Rank.THREE;
            case 4: return Rank.FOUR;
            case 5: return Rank.FIVE;
            case 6: return Rank.SIX;
            case 7: return Rank.SEVEN;
            case 8: return Rank.EIGHT;
            case 9: return Rank.NINE;
            case 10: return Rank.TEN;
            case 11: return Rank.JACK;
            case 12: return Rank.QUEEN;
            case 13: return Rank.KING;
            case 1: return Rank.ACE;
            
            default: return null;
        }
    }
}

