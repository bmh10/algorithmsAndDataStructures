package datastructures;

import datastructures.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> binarySearchTree;

    @Before
    public void before() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void test_() {
        binarySearchTree.insert(1, "testValue");
        String value = binarySearchTree.search(1);
        Assert.assertEquals("testValue", value);
    }


}
