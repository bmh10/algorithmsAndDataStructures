package algorithms.impl;

import algorithms.ISorter;

import java.util.Random;

public class RandomSorter implements ISorter {

    public void sort(int[] arr) {
        Random rand = new Random();
        final int len = arr.length;
        while (!isSorted(arr)) {
            int i = rand.nextInt(len);
            int j = rand.nextInt(len);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private boolean isSorted(int[] arr) {
        for (int n = 1; n < arr.length; n++) {
            if (arr[n-1] > arr[n]) {
                return false;
            }
        }

        return true;
    }

}
