package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: avg O(nlog(n)) worst O(n^2)
// Space: worst O(log(n))
public class QuickSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        // TODO: optimize pivot choice
        int pivot = arr.get(0);
        // TODO: implement in-place, no need to create more array lists
        List less = new ArrayList();
        List more = new ArrayList();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < pivot) {
                less.add(arr.get(i));
            } else {
                more.add(arr.get(i));
            }
        }

        less = sort(less);
        more = sort(more);
        less.add(pivot);
        less.addAll(more);
        return less;
    }
}
