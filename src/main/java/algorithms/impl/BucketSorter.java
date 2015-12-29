package algorithms.impl;

import algorithms.ISorter;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.util.ArrayList;
import java.util.List;

// Time: best O(n+k) avg O(n+k) worst O(n^2))
// Space: worst O(n)
public class BucketSorter implements ISorter {

    private static final int NUM_BUCKETS = 10;

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean allSame = true;
        int first = arr.get(0);
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            allSame &= (i == first);
        }

        if (allSame) {
            return arr;
        }

        List[] buckets = new List[NUM_BUCKETS];
        int range = max - min;
        int bucketSize = 1;
        if (range >= NUM_BUCKETS) {
            bucketSize = ((Double) Math.ceil((double) (range+1) / (double) NUM_BUCKETS)).intValue();
        }

        for (int i : arr) {
            int bucketIdx = Math.floorDiv(i - min, bucketSize);
            if (buckets[bucketIdx] == null) {
                buckets[bucketIdx] = new ArrayList();
            }
            buckets[bucketIdx].add(i);
        }

        List<Integer> sorted = new ArrayList<Integer>();
        for (List bucket : buckets) {
            sorted.addAll(sort(bucket));
        }

        return sorted;
    }
}
