package com.flitig;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Searcher implements ISearcher {
    public Searcher() {
    }

    /**
     *
     * @param root
     * @param targetVolume
     * @param visitedNodes
     * @param children
     * @return
     */
    @Override
    public INode search(INode root, int targetVolume, HashSet<Integer> visitedNodes, Queue<INode> children) {
        if (root.getFirstBottle() == root.getSecondBottle()) {
            return null;
        } else {
            return bfs(targetVolume, root, visitedNodes, children);
        }
    }

    /**
     *
     * @param targetVolume
     * @param root
     * @param visitedNodes
     * @param children
     * @return
     */
    INode bfs(int targetVolume, INode root, HashSet<Integer> visitedNodes, Queue<INode> children) {
        INode node;
        children.add(root);
        visitedNodes.add(root.getId());
        do {
            node = children.remove();
            if (node.hasTargetVolume(targetVolume)) {
                return node;

            } else {
                generateChildren(node, visitedNodes, children);
            }
        } while (!children.isEmpty());
        return null;
    }

    /**
     *
     * @param root
     * @param visitedNodes
     * @param children
     * @return
     */
    Queue<INode> generateChildren(INode root, HashSet<Integer> visitedNodes, Queue<INode> children) {
        // only implemented for use of two bottles at this time

        INode child;
        List<IBottle> bottles;

        child = new Node(Fill(root.getFirstBottle()), root.getSecondBottle(), root);
        add(child, visitedNodes, children);

        child = new Node(Empty(root.getFirstBottle()), root.getSecondBottle(), root);
        add(child, visitedNodes, children);

        bottles = Pour(root.getFirstBottle(), root.getSecondBottle());
        child = new Node(bottles.get(0), bottles.get(1), root);
        add(child, visitedNodes, children);

        child = new Node(root.getFirstBottle(), Fill(root.getSecondBottle()), root);
        add(child, visitedNodes, children);

        child = new Node(root.getFirstBottle(), Empty(root.getSecondBottle()), root);
        add(child, visitedNodes, children);

        bottles = Pour(root.getSecondBottle(), root.getFirstBottle());
        child = new Node(bottles.get(1), bottles.get(0), root);
        add(child, visitedNodes, children);

        return children;

    }

    /**
     *
     * @param child
     * @param visitedNodes
     * @param childQueue
     */
    private void add(INode child, HashSet<Integer> visitedNodes, Queue<INode> childQueue) {
        if (!visitedNodes.contains(child.getId())) {
            childQueue.add(child.copy());
            visitedNodes.add(child.getId());
        }

    }

    private List<IBottle> Pour(IBottle b, IBottle b2) {
        IBottle bCopy = b.copy();
        IBottle b2Copy = b2.copy();
        return BottleHelper.SINGLETON.PourInto(bCopy, b2Copy);

    }

    private IBottle Empty(IBottle b) {
        return BottleHelper.SINGLETON.EmptyBottle(b.copy());
    }

    private IBottle Fill(IBottle b) {
        return BottleHelper.SINGLETON.FillBottle(b.copy());
    }
}
