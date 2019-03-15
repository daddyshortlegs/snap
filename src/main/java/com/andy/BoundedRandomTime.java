package com.andy;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

class BoundedRandomTime {

    private int lower;
    private int upper;

    BoundedRandomTime(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    int getThinkingTime() {
        Random random = new Random();
        IntStream ints = random.ints(lower, upper);
        PrimitiveIterator.OfInt iterator = ints.iterator();
        return iterator.nextInt();
    }

}
