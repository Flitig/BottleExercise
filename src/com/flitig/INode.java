package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public interface INode {

    INode getParent();

    IBottle getFirstBottle();

    IBottle getSecondBottle();

    boolean hasTargetVolume(int targetVolume);

    INode copy();

    Integer getId();
}
