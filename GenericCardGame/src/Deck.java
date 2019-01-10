import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

// czy taki sposob modelowania decka jest generyczny?
//generycznosc osiagana poprzez przypisywanie kartom roznych wartosci w zaleznosci od implementacji w konkretnej grze
// restore Card i restoreCards - pod makao w ktorym zuzyte karty powracaja do decka ( ale nie caly zuzyty deck)
// zapamietywac jakos stan gry, klasa State i obiekty typu state przetrzymujace Stan w jakim znajduje sie obecnie dana gra, co ma wplyw np na liczenie Asa po 1 lub po 11
// klasa player, ktory dyktuje stan gry

public abstract class Deck {

    protected Set<Card> cards; // collections in declaration, specified subtype in initialization
    protected List<Card> currentCards = new ArrayList<>();

    protected Deck() {
        cards = new HashSet<Card>();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(r, s));
            }
        }
        currentCards.addAll(cards);
        shuffle();
    }

    public Card getCard() {
        if (currentCards.size() > 0) {
            return currentCards.remove(0);
        }
        else {
            return null;
        }
    }

    public void shuffle() {
        Collections.shuffle(currentCards);
    }
    
    public void restoreDeck(){
        currentCards.addAll(cards);
        shuffle();        
    }
    // one card retain
    public void restoreCard(Card card){
        currentCards.add(card);    
    }
    // all cards retain
    public void restoreCards(Collection<Card> cards){
        currentCards.addAll(cards);
    }
    
    public abstract int getCardValue(Card card);      

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(cards.size() + " cards:" + System.lineSeparator()); // usage of StringBuilder
                                                                                                     // wrapper is a lot more
                                                                                                     // self-documenting than
                                                                                                     // using simple string
                                                                                                     // .concat() or just
                                                                                                     // conventional '+'
        for (Card card : cards) {
            result.append(card + System.lineSeparator());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BlackJackDeck deck = new BlackJackDeck();
        for (int i = 0; i < 20; i++) {
            Card card = deck.getCard();
            System.out.println(card + " " + deck.getCardValue(card) + " " + deck.getCardValue(card, 4));
        }
    }
}
