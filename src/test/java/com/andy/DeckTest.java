package com.andy;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
    }

    @Test
    public void shouldContainCards() {
        assertWholeDeckIsPresent();
    }

    @Test
    public void shouldReturnNullWhenNoMoreCards() {
        assertWholeDeckIsPresent();
        String card = null;
        try {
            card = deck.takeCard();
        } catch (EmptyStackException e) {
            fail();
        }
        assertNull(card);
    }

    @Test
    public void shouldShuffleDeck() {
        deck.shuffle();
    }


    private void assertWholeDeckIsPresent() {
        assertDeckContainsWholeSuitOf(deck, "H");
        assertDeckContainsWholeSuitOf(deck, "S");
        assertDeckContainsWholeSuitOf(deck, "C");
        assertDeckContainsWholeSuitOf(deck, "D");
    }

    private void assertDeckContainsWholeSuitOf(Deck deck, String suit) {
        for (int i = 2; i < 11; i++) {
            assertCardValue(deck, "" + i, suit);
        }
        assertCardValue(deck, "J", suit);
        assertCardValue(deck, "Q", suit);
        assertCardValue(deck, "K", suit);
        assertCardValue(deck, "A", suit);
    }

    private void assertCardValue(Deck deck, String i, String suit) {
        assertEquals(i + suit, deck.takeCard());
    }
}