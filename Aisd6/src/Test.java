import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Wojtek on 2016-04-12.
 */
public class Test {

    public static void main(String[] args) {

        Test test = new Test();
    }

    int[] powiel(Integer[] tab2) {
        int[] tmp = new int[tab2.length];
        for (int i = 0; i < tab2.length; i++) {
            tmp[i++] = tab2[i].intValue();
        }
        return tmp;
    }

    public Test() {
        int size = 10000;
        int[] tab1 = new int[size];
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            tab1[i] = generator.nextInt(Integer.MAX_VALUE);
        }
        int[] tab2 = new int[size];
        System.arraycopy(tab1, 0, tab2, 0, size);

        Integer[][] tablice = new Integer[3][size];
        tablice[0] = Arrays.stream( tab2 ).boxed().toArray( Integer[]::new );
        ArrayList <Integer> list = new ArrayList<>();
        Collections.addAll(list, tablice[0]);
        Collections.sort(list);
        tablice[1] = list.toArray(tablice[1]);
        Collections.reverse(list);
        tablice[2] = list.toArray(tablice[2]);

        String[] string = new String[3];
        string[0] = "Dane losowe   ";
        string[1] = "Dane rosnąco  ";
        string[2] = "Dane malejąco ";

        System.out.printf("| Wielkosc: %d | MergeSort  | HeapSort   | QuickSort  | SelectSort | InsertSort| BubbleSort|\n", size);

        for (int  i = 0; i < 3; i++) {
            MergeSort mergeSort = new MergeSort();
            long start = System.currentTimeMillis();
            mergeSort.sort(powiel(tablice[i]));
            long stop = System.currentTimeMillis();
            long delta1 = stop - start;


            HeapSort heapSort = new HeapSort();
            start = System.currentTimeMillis();
            heapSort.sort(powiel(tablice[i]));
            stop = System.currentTimeMillis();
            long delta2 = stop - start;


            QuickSort quickSort = new QuickSort();
            start = System.currentTimeMillis();
            quickSort.sort(powiel(tablice[i]));
            stop = System.currentTimeMillis();
            long delta3 = stop - start;


            SelectSort selectSort = new SelectSort();
            start = System.currentTimeMillis();
            selectSort.SelectSort(powiel(tablice[i]));
            stop = System.currentTimeMillis();
            long delta4 = stop - start;


            InsertSort insertSort = new InsertSort();
            start = System.currentTimeMillis();
            insertSort.InsertSort(powiel(tablice[i]));
            stop = System.currentTimeMillis();
            long delta5 = stop - start;


            BubbleSort bubbleSort = new BubbleSort();
            start = System.currentTimeMillis();
            bubbleSort.BubbleSort(powiel(tablice[i]));
            stop = System.currentTimeMillis();
            long delta6 = stop - start;

            System.out.printf("| %s | %10d |%11d | %10d | %10d | %9d | %9d |\n", string[i] ,delta1, delta2, delta3, delta4, delta5, delta6);
        }




    }

}

