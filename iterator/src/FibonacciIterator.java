import java.util.Iterator;

// FibonacciIterator class implementing Iterator to generate Fibonacci numbers.
// It maintains its own state for the current and previous Fibonacci numbers,
// as well as a count of how many numbers have been generated so far.
// This allows multiple iterators to operate independently without interfering with each other's state.

public class FibonacciIterator implements Iterator<Integer> {
    private int current;
    private int previous;
    private int count;
    private int numberOfElements;

    public FibonacciIterator(int numberOfElements) {
        this.current = 1;
        this.previous = 0;
        this.numberOfElements = numberOfElements;
        this.count = 0;
    }

    // Would return true for the infinite Fibonacci sequence, but here it is limited by numberOfElements.
    @Override
    public boolean hasNext() {
        return count < numberOfElements;
    }

    // Returns the next Fibonacci number in the sequence.
    @Override
    public Integer next() {
        int next = current + previous;
        previous = current;
        current = next;
        count++;
        return previous;
    }

}
