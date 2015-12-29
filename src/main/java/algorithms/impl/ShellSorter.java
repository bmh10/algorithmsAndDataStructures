package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n) avg O((nlog(n))^2) worst O((nlog(n))^2)
// Space: worst O(1)
public class ShellSorter implements ISorter {

    int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        for (int gap : gaps) {

            for (int i = gap; i < arr.size(); i++) {

                // Inner insertion sort
                int x = arr.get(i);
                int j = i;

                while (j - gap >= 0 && x < arr.get(j - gap)) {
                    arr.set(j, arr.get(j - gap));
                    j -= gap;
                }

                arr.set(j, x);
            }
        }

        return arr;
    }
}
