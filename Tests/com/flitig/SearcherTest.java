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
        actual = s.generateChildren(root, new HashSet<Integer>(), actual);

        /*Queue<INode> expected = new LinkedList<>();
        expected.add(new NodeMock(3, 3, 5, 1)); // fill first
        expected.add(new NodeMock(3, 0, 5, 1)); // empty first
        expected.add(new NodeMock(3, 0, 5, 2)); // pour first into second
        expected.add(new NodeMock(3, 1, 5, 5)); // fill second
        expected.add(new NodeMock(3, 1, 5, 0)); // empty second
        expected.add(new NodeMock(3, 2, 5, 0)); // pour second into first
*/
        assertTrue(actual.remove().getId().equals(31));
        assertTrue(actual.remove().getId().equals(1));
        assertTrue(actual.remove().getId().equals(2));
        assertTrue(actual.remove().getId().equals(15));
        assertTrue(actual.remove().getId().equals(10));
        assertTrue(actual.remove().getId().equals(20));


    }

    @Test
    public void bfsTest1() throws Exception {
        INode root = new Node(new Bottle(3, 0), new Bottle(5, 0), null);
        Queue children = new LinkedList<>();

        INode actual;

        int target = 1;

        Searcher s = new Searcher();
        actual = s.bfs(target, root, new HashSet<Integer>(), children);

        assertTrue(actual.getId().equals(15));
        assertTrue(actual.getParent().getId().equals(33));
        assertTrue(actual.getParent().getParent().getId().equals(3));
        assertTrue(actual.getParent().getParent().getParent().getId().equals(30));
        assertTrue(actual.getParent().getParent().getParent().getParent().getId().equals(0));

    }

    @Test
    public void bfsTest4() throws Exception {
        INode root = new Node(new Bottle(3, 0), new Bottle(5, 0), null);
        Queue children = new LinkedList<>();

        INode actual;

        int target = 4;

        Searcher s = new Searcher();
        actual = s.bfs(target, root, new HashSet<Integer>(), children);

        assertTrue(actual.getId().equals(34));
        assertTrue(actual.getParent().getId().equals(25));
        assertTrue(actual.getParent().getParent().getId().equals(20));
        assertTrue(actual.getParent().getParent().getParent().getId().equals(2));
        assertTrue(actual.getParent().getParent().getParent().getParent().getId().equals(32));
        assertTrue(actual.getParent().getParent().getParent().getParent().getParent().getId().equals(5));
        assertTrue(actual.getParent().getParent().getParent().getParent().getParent().getParent().getId().equals(0));

    }


    @Test
    public void searchTest1() throws Exception {
        INode root = new Node(new Bottle(3, 0), new Bottle(5, 0), null);
        Queue children = new LinkedList<>();

        INode actual;

        int target = 1;

        Searcher s = new Searcher();
        actual = s.search( root, target, new HashSet<Integer>(), children);

        assertTrue(actual.getId().equals(15));
        assertTrue(actual.getParent().getId().equals(33));
        assertTrue(actual.getParent().getParent().getId().equals(3));
        assertTrue(actual.getParent().getParent().getParent().getId().equals(30));
        assertTrue(actual.getParent().getParent().getParent().getParent().getId().equals(0));

    }

    @Test
    public void searchTest4() throws Exception {
        INode root = new Node(new Bottle(3, 0), new Bottle(5, 0), null);
        Queue children = new LinkedList<>();

        INode actual;

        int target = 4;

        Searcher s = new Searcher();
        actual = s.search( root, target, new HashSet<Integer>(), children);

        assertTrue(actual.getId().equals(34));
        assertTrue(actual.getParent().getId().equals(25));
        assertTrue(actual.getParent().getParent().getId().equals(20));
        assertTrue(actual.getParent().getParent().getParent().getId().equals(2));
        assertTrue(actual.getParent().getParent().getParent().getParent().getId().equals(32));
        assertTrue(actual.getParent().getParent().getParent().getParent().getParent().getId().equals(5));
        assertTrue(actual.getParent().getParent().getParent().getParent().getParent().getParent().getId().equals(0));

    }

}