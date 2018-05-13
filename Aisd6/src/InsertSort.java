/**
 * Created by Wojtek on 2016-04-12.
 */
public class InsertSort {

    public  static void InsertSort(int[] tab2){

        int i;
        int j;
        int newValue;
        for (i = 1; i < tab2.length; i++) {
            newValue = tab2[i];
            j = i;
            while (j > 0 && tab2[j - 1] > newValue) {
                tab2[j] = tab2[j - 1];
                j--;
            }
            tab2[j] = newValue;
        }
    }

}
