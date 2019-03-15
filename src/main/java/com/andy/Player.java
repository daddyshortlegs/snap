package com.andy;

class Player {
    private final String name;
    private BoundedRandomTime thinkTime;
    private ThreadSleepWrapper sleepWrapper;

    Player(String name) {
        this.name = name;
        this.thinkTime = new BoundedRandomTime(200, 1500);
        this.sleepWrapper = new ThreadSleepWrapper();
    }

    Player(String name, BoundedRandomTime thinkTime, ThreadSleepWrapper sleepWrapper) {
        this.name = name;
        this.thinkTime = thinkTime;
        this.sleepWrapper = sleepWrapper;
    }

    String takeCard(Deck deck) {
        int thinkingTime = thinkTime.getThinkingTime();
        sleepWrapper.sleep(thinkingTime);
        return deck.takeCard();
    }

    String getName() {
        return name;
    }

    int getReactionTime() {
        return thinkTime.getThinkingTime();
    }
}
