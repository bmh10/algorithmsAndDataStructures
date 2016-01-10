package datastructures;

import datastructures.tree.RedBlackTree;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTreeTest {

    private RedBlackTree<Integer, String> redBlackTree;

    @Before
    public void before() {
        redBlackTree = new RedBlackTree<Integer, String>();
    }

    @Test
    public void test() {
        redBlackTree.insert(10, "-");
        redBlackTree.insert(5, "-");
        redBlackTree.insert(2, "-");
        redBlackTree.insert(1, "-");
        redBlackTree.insert(3, "-");
        redBlackTree.insert(6, "-");
        redBlackTree.rotateRight(redBlackTree.getRoot().getLeft());
        redBlackTree.rotateLeft(redBlackTree.getRoot().getLeft());
        System.out.print("");
    }
}
