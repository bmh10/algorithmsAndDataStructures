package datastructures;

import java.util.ArrayList;
import java.util.List;

public class IntMaxHeap {

    private List<Integer> arr;

    public IntMaxHeap() {
        this.arr = new ArrayList<Integer>();
    }

    public void heapify(List<Integer> arr) {
        // O(n)
        this.arr = arr;
        for (int i = arr.size()/2; i >= 0; i--) {
            siftDown(i);
        }


        // TODO: this is inefficient O(nlogn)
        //for (int i : arr) {
        //    insert(i);
        //}
    }

    public void insert(int val) {
        arr.add(val);
        siftUp();
    }

    private void siftUp() {
        int currentIdx = arr.size() - 1;
        int val = arr.get(currentIdx);
        Integer parentVal = getParentVal(currentIdx);

        while (parentVal != null && val > parentVal) {
            int parentIdx = getParentIdx(currentIdx);
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentVal = getParentVal(currentIdx);
        }
    }

    public int extractRoot() {
        if (arr.isEmpty()) {
            throw new NullPointerException("Heap is empty");
        }

        if (arr.size() == 1) {
            return arr.remove(0);
        }

        swap(0, arr.size() - 1);
        int removed = arr.remove(arr.size() - 1);
        siftDown();
        return removed;
    }

    private void siftDown() {
        siftDown(0);
    }

    private void siftDown(int currentIdx) {
        int largestIdx = currentIdx;
        int leftIdx = getLeftChildIdx(currentIdx);
        int rightIdx = getRightChildIdx(currentIdx);

        if (leftIdx < arr.size() && arr.get(leftIdx) > arr.get(largestIdx)) {
            largestIdx = leftIdx;
        }
        if (rightIdx < arr.size() && arr.get(rightIdx) > arr.get(largestIdx)) {
            largestIdx = rightIdx;
        }

        if (largestIdx == currentIdx) {
            return;
        }

        swap(currentIdx, largestIdx);
        siftDown(largestIdx);
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
