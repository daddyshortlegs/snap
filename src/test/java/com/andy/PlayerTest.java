package com.andy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {
    private Deck deck = new Deck();
    private Player desmond;
    private Player percy;


    @Mock
    private RandomThinkTime thinkTime;

    @Before
    public void setup() {
        desmond = new Player("Desmond", thinkTime);
        percy = new Player("Percy", thinkTime);
    }

    @Test
    public void playersShouldTakeCards() {
        when(thinkTime.getThinkingTime()).thenReturn(100,200, 500, 400);

        assertEquals("2H", desmond.takeCard(deck));
        assertEquals("3H", percy.takeCard(deck));
        assertEquals("4H", percy.takeCard(deck));
        assertEquals("5H", percy.takeCard(deck));
        verify(thinkTime).think(100);
        verify(thinkTime).think(200);
        verify(thinkTime).think(500);
        verify(thinkTime).think(400);
    }

}