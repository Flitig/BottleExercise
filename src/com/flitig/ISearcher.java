package com.flitig;

import java.util.HashSet;
import java.util.Queue;

/**
 * Created by Flitig on 2016-06-13.
 */
public interface ISearcher {

    INode search(INode root, int targetVolume, HashSet<INode> visitedNodes, Queue<INode> children);
}
