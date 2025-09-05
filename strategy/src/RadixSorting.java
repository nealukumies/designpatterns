import java.util.Arrays;

public class RadixSorting implements SortingStrategy{

    @Override
    public double getSortingTime(int[] sortArray) {
        long currentTime = System.nanoTime();
        radixSort(sortArray, sortArray.length);
        return (System.nanoTime() - currentTime) / 1e6; //converts to milliseconds
    }

    //Radix sort is a linear sorting algorithm that sorts numbers by processing individual digits. By repeatedly sorting
    //the elements based by their significant digits, the entire array gets sorted.
    //Radix sort has a time complexity of O(d*(n+b)) where d is the number of digits in the maximum number,
    //n is the number of elements in the array and b is the base for representing numbers (for decimal system b=10). So
    //in other words if d is small compared to n, the time complexity is O(n). Radix sort is efficient for large data sets.

    // Implementation adapted from https://www.geeksforgeeks.org/radix-sort/
    // A utility function to get maximum value in arr[]
    public int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    public void radixSort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }


}
