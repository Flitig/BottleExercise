package com.flitig;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Flitig on 2016-06-13.
 */
public class Searcher implements ISearcher {
    public Searcher() {
    }

    @Override
    public INode search(INode root, int targetVolume, HashSet<INode> visitedNodes, Queue<INode> children) {
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

    INode bfs(int targetVolume, INode root, HashSet<INode> visitedNodes, Queue<INode> children) {
        INode node;
        children.add(root);
        while (!children.isEmpty()) {
            node = children.remove();
            if (node.hasTargetVolume(targetVolume)) {
                return root;

            } else {
                children = generateChildren(root, visitedNodes, children);
                visitedNodes.add(root);
            }
        }
        return null;
    }


    Queue<INode> generateChildren(INode root, HashSet<INode> visitedNodes, Queue<INode> children) {
        // only implemented for use of two bottles at this time

        INode node = root.copy();
        INode child;
        List<IBottle> bottles;
        Queue<INode> childQueue = children.stream().collect(Collectors.toCollection(LinkedList<INode>::new));

        child = new Node(Fill(node.getFirstBottle()), node.getSecondBottle(), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        child = new Node(Empty(node.getFirstBottle()), node.getSecondBottle(), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        bottles = Pour(node.getFirstBottle(), node.getSecondBottle());
        child = new Node(bottles.get(0), bottles.get(1), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        child = new Node(node.getFirstBottle(), Fill(node.getSecondBottle()), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        child = new Node(node.getFirstBottle(), Empty(node.getSecondBottle()), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        bottles = Pour(node.getSecondBottle(), node.getFirstBottle());
        child = new Node(bottles.get(1), bottles.get(0), root);
        if (!visitedNodes.contains(child)) childQueue.add(child.copy());

        return childQueue;

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
