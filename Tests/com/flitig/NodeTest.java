package com.flitig;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Flitig on 2016-06-13.
 */
public class NodeTest {
    @Test
    public void getId1() throws Exception {
        INode node = new Node(new Bottle(3, 0), new Bottle(5, 1), null);
        int actual = node.getId();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId10() throws Exception {
        INode node = new Node(new Bottle(3, 1), new Bottle(5, 0), null);
        int actual = node.getId();
        int expected = 10;

        Assert.assertEquals(expected, actual);
    }
}