/**
 * Created by Wojtek on 2016-04-12.
 */
public class SelectSort {

    private static void swap(int[] tab2, int i, int j) {
        int temp = tab2[i];
        tab2[i] = tab2[j];
        tab2[j] = temp;
    }

    public static void SelectSort(int[] tab2) {
        for (int i = 0; i < tab2.length - 1; i++) {
            // Find the index of the minimum value
            int minPos = i;
            for (int j = i + 1; j < tab2.length; j++) {
                if (tab2[j] < tab2[minPos]) {
                    minPos = j;
                }
            }
            swap(tab2, minPos, i);
        }

    }
}