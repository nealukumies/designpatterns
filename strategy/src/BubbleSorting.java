public class BubbleSorting implements SortingStrategy{

    @Override
    public double getSortingTime(int[] sortArray) {
        long currentTime = System.nanoTime();
        bubbleSort(sortArray, sortArray.length);
        return (System.nanoTime() - currentTime) / 1e6; //converts to milliseconds
    }

    //Bubblesort sorts using multiple passes starting with positioning the maximum element to the end, then
    //second largest to the second last position and so on.
    //Bubblesort has a time complexity of O(n2) and is very slow for large data sets.
    //Implementation adapted from https://www.geeksforgeeks.org/bubble-sort/
    public void bubbleSort(int arr[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

}
