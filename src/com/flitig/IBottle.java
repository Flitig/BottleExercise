package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public interface IBottle {
    int getCurrentVolume();

    void setCurrentVolume(int currentVolume);

    int getMaxCapacity();

    IBottle copy();

    int getFreeCapacity();
}
