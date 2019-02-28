package com.andy;

import java.util.*;

class Deck {
    private Stack<String> cards = new Stack<>();

    Deck() {
        createSuit("D");
        createSuit("C");
        createSuit("S");
        createSuit("H");
    }

    private void createSuit(String suit) {
        cards.add("A" + suit);
        cards.add("K" + suit);
        cards.add("Q" + suit);
        cards.add("J" + suit);
        for (int i = 10; i > 1; i--) {
            cards.add(i + suit);
        }
    }

    String takeCard() {
        String card = null;
        try {
            card = cards.pop();
        } catch (EmptyStackException e) {
        }

        return card;
    }

    void shuffle() {
        Collections.shuffle(cards);
    }
}
