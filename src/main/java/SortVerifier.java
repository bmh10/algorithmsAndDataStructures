import java.util.List;

public class SortVerifier {

    public boolean isSorted(List<Integer> arr) {
        for (int n = 1; n < arr.size(); n++) {
            if (arr.get(n-1) > arr.get(n)) {
                return false;
            }
        }

        return true;
    }
}
