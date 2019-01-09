
/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public enum Suit {

    SPADE(2),
    HEART(3),
    CLUB(1),
    DIAMOND(4);
    
    private int suitValue;
    
    public int getSuitValue() {
        return suitValue;
    }
    
    private Suit(int suitValue){
        suitValue = suitValue;
    }
}

