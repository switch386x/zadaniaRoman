import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

// czy taki sposob modelowania decka jest generyczny?

public class Deck {

    private List<Card> cards; // collections in declaration, specified subtype in initialization
    
    protected Deck(){
        cards = new ArrayList<Card>();
        
        for (Rank r : Rank.values()){
            for (Suit s : Suit.values()){
                cards.add(new Card(r,s));
            }
        }
    }
    
    private Deck(Collection<? extends Card> cards)
    {
        this.cards = new ArrayList<Card>(cards);
    }
   
    
    public static void main(String[] args){
        Deck deck = new Deck();
        System.out.println(deck);
        
        ArrayList<Deck> playerHands = deck.dealAllCards(5);
        
        for (Deck playerHand : playerHands){
            System.out.println(playerHand);
        }
    }
    
    public ArrayList<Deck> dealAllCards(int numberOfPlayers) // to jest do przepisania - jak rozdawac karty do gry w blackjacka
    {
        ArrayList<Deck> playerHands = new ArrayList<>(numberOfPlayers);
        ArrayList<Card> shuffledDeck = new ArrayList<>(cards);

        int cardsPerPlayer = shuffledDeck.size()/numberOfPlayers; // to be subtracted by 1 after dealing remaining cards
        int remainingCards = shuffledDeck.size()%numberOfPlayers;

        Collections.shuffle(shuffledDeck);
        
        int firstCardIndex = 0;
        int lastCardIndex = 0;

        for (int player = 0; player < numberOfPlayers; ++player)
        {
            if (player == remainingCards) 
            {
                --cardsPerPlayer; // all remaining cards dealed
            }   

            lastCardIndex = firstCardIndex + cardsPerPlayer + 1;    

            playerHands.add(new Deck(shuffledDeck.subList(firstCardIndex, lastCardIndex)));

            firstCardIndex = lastCardIndex;
        }

        return playerHands;
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(cards.size() + " cards:" + System.lineSeparator());    // usage of StringBuilder wrapper is a lot more self-documenting than using simple string .concat() or just conventional '+'
        for (Card card : cards){
            result.append(card + System.lineSeparator());
        }
        return result.toString();
    }
}

