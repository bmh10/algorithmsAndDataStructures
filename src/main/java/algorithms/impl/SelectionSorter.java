package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Time: best O(n^2) avg O(n^2) worst O(n^2)
// Space: worst O(1)
public class SelectionSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        for (int i = 0; i < arr.size(); i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minIdx)) {
                    minIdx = j;
                }
            }

            if (i != minIdx) {
                swap(arr, i, minIdx);
            }
        }

        return arr;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
