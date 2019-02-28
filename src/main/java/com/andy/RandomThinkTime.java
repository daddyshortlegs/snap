package com.andy;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

class RandomThinkTime {

    int getThinkingTime() {
        Random random = new Random();
        IntStream ints = random.ints(200, 1500);
        PrimitiveIterator.OfInt iterator = ints.iterator();
        return iterator.nextInt();
    }

    void think(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

}
