package com.andy;

class ThreadSleepWrapper {
    private int time;

    public ThreadSleepWrapper(int time) {
        this.time = time;
    }

    public void invoke() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
