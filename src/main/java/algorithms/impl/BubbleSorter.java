package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n) avg O(n^2) worst O(n^2)
// Space: worst O(1)
public class BubbleSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        int n = arr.size();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < n; i++) {
                if (arr.get(i) < arr.get(i - 1)) {
                    swap(arr, i, i-1);
                    sorted = false;
                }
            }

            n--;
        }

        return arr;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
