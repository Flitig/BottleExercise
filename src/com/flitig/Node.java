package com.flitig;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Node implements INode{

    private final IBottle firstBottle;
    private final IBottle secondBottle;

    public Node(IBottle firstBottle, IBottle secondBottle) {

        this.firstBottle = firstBottle;
        this.secondBottle = secondBottle;
    }

    public IBottle getFirstBottle() {
        return firstBottle;
    }

    public IBottle getSecondBottle() {
        return secondBottle;
    }
}
