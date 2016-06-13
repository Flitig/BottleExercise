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

    @Override
    public INode search(INode root, int targetVolume, HashSet<Integer> visitedNodes, Queue<INode> children) {
        if (root.getFirstBottle() == root.getSecondBottle()) {
            return null;
        }
        children.add(root);
        while (!children.isEmpty()) {
            if (root.hasTargetVolume(targetVolume)) return root;
            else {
                return bfs(targetVolume, root, visitedNodes, children);
            }
        }
        return root;
    }

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
