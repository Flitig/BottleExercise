package com.flitig;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Flitig on 2016-06-14.
 */
public class NodeHelperTest {
    @Test
    public void getPath() throws Exception {
        Node grandparent = new Node(new Bottle(5, 3), new Bottle(4, 2));
        Node parent = new Node(new Bottle(5, 1), new Bottle(4, 1), grandparent);
        Node child = new Node(new Bottle(5, 4), new Bottle(4, 3), parent);

        NodeHelper nodeHelper = new NodeHelper();
        List<Integer> path1 = nodeHelper.getPath(grandparent);
        List<Integer> path2 = nodeHelper.getPath(parent);
        List<Integer> path3 = nodeHelper.getPath(child);

        List<Integer> expected1 = new LinkedList<>();
        List<Integer> expected2 = new LinkedList<>();
        List<Integer> expected3 = new LinkedList<>();
        expected1.add(32);
        expected2.add(32);
        expected3.add(32);
        expected2.add(11);
        expected3.add(11);
        expected3.add(43);


        Assert.assertEquals(expected1, path1);
        Assert.assertEquals(expected2, path2);
        Assert.assertEquals(expected3, path3);

    }

}