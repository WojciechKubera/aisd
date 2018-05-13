/**
 * Created by Wojtek on 2016-04-12.
 */
public class InsertSort {

    public void sort(int[] tab2, int h){

        int i;
        int j;
        int newValue;
        for (i = h; i < tab2.length; i++) {
            newValue = tab2[i];
            j = i;
            while (j - h >= 0 && tab2[j - h] > newValue) {
                tab2[j] = tab2[j - h];
                j-= h;
            }
            tab2[j] = newValue;
        }
    }

}
