import algorithms.ISorter;
import algorithms.SorterType;
import algorithms.impl.QuickSorter;
import exception.AlgorithmNotFoundException;

public class SorterFactory {

    public ISorter build(SorterType type) {
        switch (type) {
            case QUICKSORT:
                return new QuickSorter();
        }

        throw new AlgorithmNotFoundException(String.format("The algorithm %s could not be found", type.toString()));
    }
}
