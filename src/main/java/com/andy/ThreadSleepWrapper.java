package com.andy;

class ThreadSleepWrapper {
    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {
        }
    }
}
