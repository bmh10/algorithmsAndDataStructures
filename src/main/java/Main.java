import algorithms.ISorter;
import algorithms.SorterType;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        SorterFactory sorterFactory = new SorterFactory();
        SortVerifier sortVerifier = new SortVerifier();

        int[] testSample = {1,6,2,7,8,10,65};

        for (SorterType type : SorterType.values()) {
            ISorter sorter = sorterFactory.build(type);
            int[] arr = Arrays.copyOf(testSample, testSample.length);
            long memBef = Runtime.getRuntime().totalMemory();
            long start = System.nanoTime();
            sorter.sort(arr);
            long end = System.nanoTime();
            long memAft = Runtime.getRuntime().totalMemory();


            boolean success = sortVerifier.verifySortResult(testSample, arr);
            System.out.println("Algorithm: " + type.toString());
            System.out.println("Success: " + success);
            System.out.println("Runtime: " + (end-start) + "ns");
            System.out.println("Mem usage: " + (memAft-memBef) + " bytes");

        }
    }
}
