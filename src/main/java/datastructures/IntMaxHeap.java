package datastructures;

import java.util.ArrayList;
import java.util.List;

public class IntMaxHeap {

    private List<Integer> arr;

    public IntMaxHeap() {
        this.arr = new ArrayList<Integer>();
    }

    public void heapify(List<Integer> arr) {
        // TODO: this is inefficient O(nlogn)
        for (int i : arr) {
            insert(i);
        }
    }

    public void insert(int val) {
        arr.add(val);
        int currentIdx = arr.size() - 1;
        Integer parentVal = getParentVal(currentIdx);

        while (parentVal != null && val > parentVal) {
            int parentIdx = getParentIdx(currentIdx);
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentVal = getParentVal(currentIdx);
        }
    }

    public int extract() {
        if (arr.isEmpty()) {
            return 0;
        }

        if (arr.size() == 1) {
            return arr.remove(0);
        }

        swap(0, arr.size()-1);
        int removed = arr.remove(arr.size()-1);

        int val = arr.get(0);
        int currentIdx = 0;
        int nextToSwapIdx = 0;
        Integer leftChildVal = getLeftChildVal(0);
        Integer rightChildVal = getRightChildVal(0);

        while ((leftChildVal != null && val < leftChildVal)
            || (rightChildVal != null && val < rightChildVal)) {

            if (leftChildVal != null && val < leftChildVal
             && rightChildVal != null && val < rightChildVal) {
                if (leftChildVal > rightChildVal) {
                    nextToSwapIdx = getLeftChildIdx(currentIdx);
                } else {
                    nextToSwapIdx = getRightChildIdx(currentIdx);
                }
            } else if (leftChildVal != null && val < leftChildVal) {
                nextToSwapIdx = getLeftChildIdx(currentIdx);
            } else {
                nextToSwapIdx = getRightChildIdx(currentIdx);
            }

            swap(currentIdx, nextToSwapIdx);
            currentIdx = nextToSwapIdx;

            leftChildVal = getLeftChildVal(currentIdx);
            rightChildVal = getRightChildVal(currentIdx);
        }

        return removed;
    }

    private void swap(int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    public void print() {
        int nodes = 1;
        for (int i = 0; i < arr.size();) {
            for (int j = 0; j < nodes; j++) {
                if (i+j < arr.size()) {
                    System.out.print(arr.get(i + j) + " ");
                }
            }
            i+= nodes;
            nodes *= 2;
            System.out.println();
        }
    }

    private int getParentIdx(int idx) {
        return ((Double)Math.floor((idx-1d)/2d)).intValue();
    }

    private Integer getParentVal(int idx) {
        try {
            return arr.get(getParentIdx(idx));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private int getLeftChildIdx(int idx) {
        return 2*idx + 1;
    }

    private Integer getLeftChildVal(int idx) {
        try {
            return arr.get(getLeftChildIdx(idx));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private int getRightChildIdx(int idx) {
        return 2*idx + 2;
    }

    private Integer getRightChildVal(int idx) {
        try {
            return arr.get(getRightChildIdx(idx));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
