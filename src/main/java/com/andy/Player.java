package com.andy;

class Player {
    private final String name;
    private final RandomThinkTime thinkTime;

    Player(String name, RandomThinkTime thinkTime) {
        this.name = name;
        this.thinkTime = thinkTime;
    }

    String takeCard(Deck deck) {
        int thinkingTime = thinkTime.getThinkingTime();
        thinkTime.think(thinkingTime);
        return deck.takeCard();
    }

    String getName() {
        return name;
    }

    int getReactionTime() {
        return thinkTime.getThinkingTime();
    }
}
