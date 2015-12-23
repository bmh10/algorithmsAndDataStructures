package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;

// Time: all O(nlog(n))
// Space: worst O(n)
public class MergeSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        int split = arr.size()/2;
        List<Integer> lower = arr.subList(0, split);
        List<Integer> upper = arr.subList(split, arr.size());
        return merge(sort(lower), sort(upper));
    }

    private List<Integer> merge(List<Integer> a, List<Integer> b) {
        int aidx = 0;
        int bidx = 0;
        List<Integer> merged = new ArrayList<Integer>();
        while (aidx < a.size() && bidx < b.size()) {
            if (a.get(aidx) < b.get(bidx)) {
                merged.add(a.get(aidx));
                aidx++;
            } else {
                merged.add(b.get(bidx));
                bidx++;
            }
        }

        return merged;
    }
}
