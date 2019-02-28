package com.andy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SnapTest {
    @Mock
    private Deck deck;
    @Mock
    private Player player1;
    @Mock
    private Player player2;
    @Mock
    private GameOutputter outputter;


    Snap snap;

    @Before
    public void setup() {
        when(player1.getName()).thenReturn("Dave");
        when(player2.getName()).thenReturn("Archie");
        snap = new Snap(deck, player1, player2, outputter);
    }

    @Test
    public void verifyDeckIsShuffled() {
        snap.play();
        verify(deck).shuffle();
    }

    @Test
    public void onePlayerTakesTurn() {
        when(player1.takeCard(deck)).thenReturn("AS", null);
        snap.play();
        verify(deck).shuffle();
        verify(outputter).output("Dave turns 'AS'");
        verify(outputter).output("No winner");
    }

    @Test
    public void secondPlayerTakesTurn() {
        when(player1.takeCard(deck)).thenReturn("AS", null);
        when(player2.takeCard(deck)).thenReturn("2C", null);
        snap.play();
        verify(outputter).output("Dave turns 'AS'");
        verify(outputter).output("Archie turns '2C'");
        verify(outputter).output("No winner");
    }

    @Test
    public void thirdTurn() {
        when(player1.takeCard(deck)).thenReturn("AS", "8D", null);
        when(player2.takeCard(deck)).thenReturn("2C", null);
        snap.play();
        verify(outputter).output("Dave turns 'AS'");
        verify(outputter).output("Archie turns '2C'");
        verify(outputter).output("Dave turns '8D'");
        verify(outputter).output("No winner");
    }

    @Test
    public void testWinner() {
        when(player1.takeCard(deck)).thenReturn("AS", "9H", null);
        when(player2.takeCard(deck)).thenReturn("9D", null);
        when(player1.getReactionTime()).thenReturn(1000);
        when(player2.getReactionTime()).thenReturn(1200);

        snap.play();
        verify(outputter).output("Dave turns 'AS'");
        verify(outputter).output("Archie turns '9D'");
        verify(outputter).output("Dave turns '9H'");
        verify(outputter).output("Dave wins!");
    }

    @Test
    public void testOtherWinner() {
        when(player1.takeCard(deck)).thenReturn("AS", "8H", null);
        when(player2.takeCard(deck)).thenReturn("9D", "8C", null);
        when(player1.getReactionTime()).thenReturn(1300);
        when(player2.getReactionTime()).thenReturn(1200);

        snap.play();
        verify(outputter).output("Dave turns 'AS'");
        verify(outputter).output("Archie turns '9D'");
        verify(outputter).output("Dave turns '8H'");
        verify(outputter).output("Archie turns '8C'");
        verify(outputter).output("Archie wins!");
    }


}

