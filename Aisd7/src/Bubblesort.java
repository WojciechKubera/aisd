
public class Bubblesort {

    public void sort(int[] tab2, int h) {

        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i <= tab2.length - j - h; i++) {
                if (tab2[i] > tab2[i + h]) {
                    tmp = tab2[i];
                    tab2[i] = tab2[i + h];
                    tab2[i + h] = tmp;
                    swapped = true;
                }
            }
        }

    }
}