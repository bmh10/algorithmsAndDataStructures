package algorithms.impl;

import algorithms.ISorter;
import datastructures.IntMaxHeap;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n) avg O(nlog(n)) worst O(nlog(n))
// Space: worst O(n)
public class TimSorter implements ISorter {



    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        return arr;
    }
}
