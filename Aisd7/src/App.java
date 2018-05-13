/**
 * Created by Wojtek on 2016-04-19.
 */
public class App {
    public static void main(String[] args) {
        App a = new App();
    }

    App() {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        //InsertSort ins = new InsertSort(arr, 8);
        //Bubblesort sort = new Bubblesort(arr, 8);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
