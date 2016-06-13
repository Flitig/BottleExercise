package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Node implements INode {

    private final IBottle firstBottle;
    private final IBottle secondBottle;
    private final INode parent;
    private final Integer Id;
    public Node(IBottle firstBottle, IBottle secondBottle, INode parent) {

        this.firstBottle = firstBottle;
        this.secondBottle = secondBottle;
        this.parent = parent;
        this.Id = firstBottle.getCurrentVolume() * 10 + secondBottle.getCurrentVolume();
    }

    public Node(IBottle firstBottle, IBottle secondBottle) {
        this(firstBottle, secondBottle, null);
    }

    @Override
    public INode getParent() {
        return parent;
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
        return (firstBottle.getCurrentVolume() == targetVolume || secondBottle.getCurrentVolume() == targetVolume);
    }

    @Override
    public INode copy() {
        return new Node(firstBottle.copy(), secondBottle.copy(), this.parent);
    }

    @Override
    public Integer getId() {
        return Id;
    }
}
