import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortingStrategy bubbleSort = new BubbleSorting();
        SortingStrategy mergeSort = new MergeSorting();
        SortingStrategy radixSort = new RadixSorting();
        int[] numbers = new int[30];
        int[] moreNumbers = new int[100000];
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000); // random number from 0 to 9999
        }

        for (int i = 0; i < moreNumbers.length; i++) {
            moreNumbers[i] = rand.nextInt(10000);
        }

        System.out.println("Bubble Sort Strategy takes " + bubbleSort.getSortingTime(numbers) + " ms for an array with 30 integers.");
        //It´s ridiculously slow for large arrays, so test bubblesort with long arrays only when you feel patient enough.
        //System.out.println("Bubble Sort Strategy takes " + bubbleSort.getSortingTime(moreNumbers) + " ms for an array with 100 000 integers.");
        System.out.println("Merge Sort Strategy takes " + mergeSort.getSortingTime(numbers) + " ms for an array with 30 integers.");
        System.out.println("Merge Sort Strategy takes " + mergeSort.getSortingTime(moreNumbers) + " ms for an array with 100 000 integers.");
        System.out.println("Radix Sort Strategy takes " + radixSort.getSortingTime(numbers) + " ms for an array with 30 integers.");
        System.out.println("Radix Sort Strategy takes " + radixSort.getSortingTime(moreNumbers) + " ms for an array with 100 000 integers.");

    }
}
