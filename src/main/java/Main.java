import algorithms.ISorter;
import algorithms.SorterType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SorterFactory sorterFactory = new SorterFactory();
        SortVerifier sortVerifier = new SortVerifier();
        SetGenerator setGenerator = new SetGenerator();

        int[] sampleSizes = { 10 , 11, 100, 1000 };

        for (int sampleSize : sampleSizes) {
            List<Integer> testSample = setGenerator.generateSet(sampleSize);
            System.out.println("Sample size: " + sampleSize);

            for (SorterType type : SorterType.values()) {
                ISorter sorter = sorterFactory.build(type);
                List<Integer> testArr = new ArrayList<Integer>(testSample);

                long start = System.nanoTime();
                List<Integer> sortedArr = sorter.sort(testArr);
                long end = System.nanoTime();

                boolean success = sortVerifier.isSorted(sortedArr);
                System.out.print("Algorithm: " + type.toString());
                System.out.print(" | Success: " + success);
                System.out.print(" | Runtime: " + ((double)(end - start))/1000d + "ms\n");
                //System.out.print(" | Output: " + sortedArr + "\n");
            }

            System.out.println();
        }
    }
}
