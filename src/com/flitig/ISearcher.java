package com.flitig;

import java.util.HashSet;
import java.util.Queue;

/**
 * Created by Flitig on 2016-06-13.
 */
interface ISearcher {

    INode search(INode root, int targetVolume, HashSet<Integer> visitedNodes, Queue<INode> children);
}
