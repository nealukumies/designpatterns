
import java.util.Iterator;

// FibonacciSequence class implementing Iterable and SequenceInterface
// to provide an iterator for Fibonacci numbers.
// It uses the FibonacciIterator to generate the sequence up to a specified number of elements.
// If this class would store the sequence or the state of iteration, the use of multiple
// iterators would lead to inconsistencies as they would share the same state. If one iterator
// advances, it would affect the state of the other iterators, leading to incorrect results.


public class FibonacciSequence implements Iterable<Integer>, SequenceInterface {
    private int numberOfElements;

    public FibonacciSequence(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(numberOfElements);
    }

}
