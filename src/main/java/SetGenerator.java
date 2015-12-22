import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetGenerator {

    private static final int BOUND = 1024;

    public List<Integer> generateSet(int n) {
        Random rand = new Random();
        List<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(rand.nextInt(BOUND));
        }

        return arr;
    }
}
