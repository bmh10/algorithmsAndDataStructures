package datastructures;

import java.util.ArrayList;
import java.util.List;

public class IntMaxHeap {

    private List<Integer> arr;

    public IntMaxHeap() {
        this.arr = new ArrayList<Integer>();
    }

    public IntMaxHeap(List<Integer> arr) {
        this.arr = arr;
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

    public void extract(int val) {
        
    }

    private void swap(int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
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
