package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public interface INode {

    INode getParent();

    IBottle getFirstItem();

    IBottle getSecondItem();

    boolean hasTargetValue(int targetVolume);

    INode copy();

    Integer getId();
}
