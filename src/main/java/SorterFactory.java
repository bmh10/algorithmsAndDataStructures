import algorithms.ISorter;
import algorithms.SorterType;
import algorithms.impl.*;
import exception.AlgorithmNotFoundException;

public class SorterFactory {

    public ISorter build(SorterType type) {
        switch (type) {
            //case RANDOM:
            //    return new RandomSorter();
            case QUICKSORT:
                return new QuickSorter();
            case MERGESORT:
                return new MergeSorter();
            case BUBBLESORT:
                return new BubbleSorter();
            case INSERTIONSORT:
                return new InsertionSorter();
            case SELECTIONSORT:
                return new SelectionSorter();
            case HEAPSORT:
                return new HeapSorter();
            case SHELLSORT:
                return new ShellSorter();
            case BUCKETSORT:
                return new BucketSorter();
        }

        throw new AlgorithmNotFoundException(String.format("The algorithm %s could not be found", type.toString()));
    }
}
