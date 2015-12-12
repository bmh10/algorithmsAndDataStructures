import java.util.Arrays;

public class SortVerifier {

    public boolean isSorted(int[] arr) {
        for (int n = 1; n < arr.length; n++) {
            if (arr[n-1] > arr[n]) {
                return false;
            }
        }

        return true;
    }
}
