public class Main {

    public static void main(String[] args) {
        System.out.println("Iterator Pattern with Fibonacci Sequence");
        // Create a FibonacciSequence with 10 elements
        // Iterate through the sequence and print each Fibonacci number, but the sequence is generated on-the-fly
        // meaning it does not store all numbers in memory at all.
        // For clarity: This for loop calls the iterator() method of FibonacciSequence,
        // which returns a new FibonacciIterator instance. The for-each loop then uses this iterator
        // to get each Fibonacci number one by one. The iterator maintains its own state that includes
        // the current and previous Fibonacci numbers, as well as a count of how many numbers have
        // been generated so far. This allows the iterator to generate the Fibonacci sequence on-the-fly
        // without storing all numbers in memory at once.

        // Note: Number of elements isn´t limited here, but as the iterator is <Integer>, it will overflow at some point
        // if you try to go too high in the sequence. Should be changed to <Long> or <BigInteger> for larger sequences.
        FibonacciSequence fibonacciSequence = new FibonacciSequence(10);
        for (int number : fibonacciSequence) {
            System.out.print(number + " ");
        }
    }

}