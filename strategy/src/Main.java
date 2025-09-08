import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[30];
        int[] moreNumbers = new int[100000];
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000); // random number from 0 to 9999
        }

        for (int i = 0; i < moreNumbers.length; i++) {
            moreNumbers[i] = rand.nextInt(10000);
        }

        SortContext context = new SortContext();
        context.setSortingStrategy(new BubbleSorting());
        System.out.println("Bubble Sort Strategy takes " + context.executeSort(numbers) + " ms for an array with 30 integers.");
        //It´s ridiculously slow for large arrays, so test bubblesort with long arrays only when you feel patient enough (several seconds - > over a minute).
        //System.out.println("Bubble Sort Strategy takes " + context.executeSort(moreNumbers) + " ms for an array with 100 000 integers.");
        context.setSortingStrategy(new MergeSorting());
        System.out.println("Merge Sort Strategy takes " + context.executeSort(numbers) + " ms for an array with 30 integers.");
        System.out.println("Merge Sort Strategy takes " + context.executeSort(moreNumbers) + " ms for an array with 100 000 integers.");
        context.setSortingStrategy(new RadixSorting());
        System.out.println("Radix Sort Strategy takes " + context.executeSort(numbers) + " ms for an array with 30 integers.");
        System.out.println("Radix Sort Strategy takes " + context.executeSort(moreNumbers) + " ms for an array with 100 000 integers.");


    }
}
