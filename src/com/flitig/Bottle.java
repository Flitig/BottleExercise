package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Bottle implements IBottle {
    private final int maxCapacity;
    private int currentVolume;

    public Bottle(int maxCapacity, int currentVolume) {
        this.maxCapacity = maxCapacity;
        this.currentVolume = currentVolume;
    }

    @Override
    public int getCurrentVolume() {
        return currentVolume;
    }

    @Override
    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }
}
