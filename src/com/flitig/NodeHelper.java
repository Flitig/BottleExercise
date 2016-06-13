package com.flitig;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Flitig on 2016-06-14.
 */
public class NodeHelper {
    List<Integer> getPath(INode targetNode) {
        List<Integer> path = new LinkedList<>();
        path.add(getParentPath(targetNode, path));
        return path;
    }

    Integer getParentPath(INode targetNode, List<Integer> path) {
        if (targetNode.getParent() == null) {
            return targetNode.getId();
        } else {
            path.add(getParentPath(targetNode.getParent(), path));
        }
        return targetNode.getId();
    }
}

