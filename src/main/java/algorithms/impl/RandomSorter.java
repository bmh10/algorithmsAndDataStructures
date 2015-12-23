package algorithms.impl;

import algorithms.ISorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSorter implements ISorter {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return new ArrayList<Integer>();
        }
        if (arr.isEmpty() || arr.size() == 1) {
            return arr;
        }
        Random rand = new Random();
        final int len = arr.size();
        while (!isSorted(arr)) {
            int i = rand.nextInt(len);
            int j = rand.nextInt(len);
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }

        return arr;
    }

    private boolean isSorted(List<Integer> arr) {
        for (int n = 1; n < arr.size(); n++) {
            if (arr.get(n-1) > arr.get(n)) {
                return false;
            }
        }

        return true;
    }

}
