package com.andy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomThinkTimeTest {

    @Test
    public void reactionTimeShouldBeBetween200and1500Ms() {
        RandomThinkTime thinkTime = new RandomThinkTime();

        for (int i = 0; i < 100; i++) {
            int reactionTime = thinkTime.getThinkingTime();
            assertTrue(reactionTime >= 200 && reactionTime <= 1500);
        }
    }

}