import java.util.Arrays;

public class SortVerifier {

    /**
     * Verify that output is sorted correctly by comparing with Java's
     * inbuilt implementation of Dual Pivot Quicksort.
     */
    public boolean verifySortResult(int[] input, int[] sorterOutput) {
        Arrays.sort(input);
        return Arrays.equals(input, sorterOutput);
    }
}
