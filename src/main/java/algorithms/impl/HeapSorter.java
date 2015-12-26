package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n^2) avg O(n^2) worst O(n^2)
// Space: worst O(1)
public class HeapSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        heapify(arr);


        return arr;
    }

    // Builds max-heap from list in O(n)
    private List<Integer> heapify(List<Integer> arr) {

    }





}
