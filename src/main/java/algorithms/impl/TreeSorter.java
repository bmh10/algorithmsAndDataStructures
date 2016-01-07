package algorithms.impl;

import algorithms.ISorter;
import datastructures.IntMaxHeap;
import datastructures.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// Time: best O(nlog(n)) avg O(nlog(n)) worst O(n^2)
// Space: worst O(n)
public class TreeSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<Integer, String>(arr);

        List<Integer> sorted = binarySearchTree.flatten_depthFirst_inOrder();
        return sorted;
    }
}
