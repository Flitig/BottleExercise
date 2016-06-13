package com.flitig;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by Flitig on 2016-06-13.
 */
public class SearcherTest {
    @Test
    public void generateChildrenTest() throws Exception {
        INode root = new Node(new Bottle(3, 1), new Bottle(5, 1), null);
        Queue<INode> actual = new LinkedList<>();

        Searcher s = new Searcher();
        actual = s.generateChildren(root, new HashSet<>(), actual);

        /*Queue<INode> expected = new LinkedList<>();
        expected.add(new NodeMock(3, 3, 5, 1)); // fill first
        expected.add(new NodeMock(3, 0, 5, 1)); // empty first
        expected.add(new NodeMock(3, 0, 5, 2)); // pour first into second
        expected.add(new NodeMock(3, 1, 5, 5)); // fill second
        expected.add(new NodeMock(3, 1, 5, 0)); // empty second
        expected.add(new NodeMock(3, 2, 5, 0)); // pour second into first
*/
        assertEquals(31, actual.remove().getId());
        assertEquals(1, actual.remove().getId());
        assertEquals(2, actual.remove().getId());
        assertEquals(15, actual.remove().getId());
        assertEquals(10, actual.remove().getId());
        assertEquals(20, actual.remove().getId());

    }

}