package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Node implements INode{

    private final IBottle firstBottle;
    private final IBottle secondBottle;
    private final INode parent;

    public Node(IBottle firstBottle, IBottle secondBottle, INode parent) {

        this.firstBottle = firstBottle;
        this.secondBottle = secondBottle;
        this.parent = parent;
    }

    public Node(IBottle firstBottle, IBottle secondBottle) {
        this(firstBottle, secondBottle, null);
    }

    @Override
    public IBottle getFirstBottle() {
        return firstBottle;
    }

    @Override
    public IBottle getSecondBottle() {
        return secondBottle;
    }

    @Override
    public boolean hasTargetVolume(int targetVolume) {
        return false;
    }

    @Override
    public INode copy() {
        return new Node(firstBottle.copy(), secondBottle.copy(), this.parent);
    }

    @Override
    public IBottle[] getBottles() {
        return new IBottle[]{firstBottle, secondBottle};
    }

    @Override
    public int getId() {
        return firstBottle.getCurrentVolume()*10+secondBottle.getCurrentVolume();
    }
}
