/**
 * Created by Wojtek on 2016-04-12.
 */
public class QuickSort {

    private int[] numbers;
    private int number;

    public void sort(int[] tab2) {
        // check for empty or null array
        if (tab2 ==null || tab2.length==0){
            return;
        }
        this.numbers = tab2;
        number = tab2.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
