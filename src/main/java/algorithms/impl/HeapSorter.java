package algorithms.impl;

import algorithms.ISorter;
import datastructures.IntMaxHeap;

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

        IntMaxHeap maxHeap = new IntMaxHeap();
        maxHeap.heapify(arr);
        //maxHeap.print();

        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            sorted.add(0, maxHeap.extractRoot());
        }

        return sorted;
    }
}
