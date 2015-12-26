package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n) avg O(n^2) worst O(n^2)
// Space: worst O(1)
public class InsertionSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        for (int i = 1; i < arr.size(); i++) {
            int x = arr.get(i);
            int j = i;
            while (j > 0 && x < arr.get(j-1)) {
                arr.set(j, arr.get(j-1));
                j--;
            }
            arr.set(j, x);
        }

        return arr;
    }
}
