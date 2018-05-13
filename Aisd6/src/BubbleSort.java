/**
 * Created by Wojtek on 2016-04-12.
 */
public class BubbleSort {

    public static void BubbleSort(int[] tab2) {

        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < tab2.length - j; i++) {
                if (tab2[i] > tab2[i + 1]) {
                    tmp = tab2[i];
                    tab2[i] = tab2[i + 1];
                    tab2[i + 1] = tmp;
                    swapped = true;
                }
            }
        }

    }
}