package com.andy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoundedRandomTimeTest {

    @Test
    public void reactionTimeShouldBeBetween200and1500Ms() {
        BoundedRandomTime thinkTime = new BoundedRandomTime(200, 1500);

        for (int i = 0; i < 100; i++) {
            int reactionTime = thinkTime.getThinkingTime();
            assertTrue(reactionTime >= 200 && reactionTime <= 1500);
        }
    }

}