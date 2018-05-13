import java.util.Random;

/**
 * Created by Wojtek on 2016-04-19.
 */
public class Test {

    public static void main(String[] args) {

        Test test = new Test();
    }

    public Test() {
        int size = 5000;

        int[] tab1 = new int[size];
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            tab1[i] = generator.nextInt(Integer.MAX_VALUE);
        }
        {//dopisane
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = size/2;
            while (h <= size) h = 3*h+1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h >= 1) {
                insertSort.sort(tab2, h);
                System.out.println(h);
                h *=0.75 ;
            }
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 1/a =" + delta5);
        }

        {//3h+1\1
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = 3*h+1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h >= 1) {
                insertSort.sort(tab2, h);
                System.out.println(h);
                h /=3 ;
            }
            long start = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 1/a =" + delta5);
        }

        {//2^k-1\1
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h * 2;
            h -= 1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h >= 1) {
                insertSort.sort(tab2, h);
               // System.out.println(h);
                h /= 2;
            }
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 1/b =" + delta5);
        }

        {//2^k+1\1
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h * 2;
            h += 1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h >= 3) {
                insertSort.sort(tab2, h);
                //System.out.println(h);
                h = h/2+1;
            }
            insertSort.sort(tab2, 1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 1/c =" + delta5);
        }

        { // fibonaci\1
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            int n = 1;
            while (h <= size) h = fib(n++);

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h >= 1) {
                insertSort.sort(tab2, h);
               // System.out.println(h);
                h = fib(--n);
            }
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 1/d =" + delta5);
        }
        {//3h+1\2
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = 3*h+1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                insertSort.sort(tab2, h);
              //  System.out.println(h);
                h /= 3;
            }
            Bubblesort bubblesort = new Bubblesort();
            bubblesort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 2/a =" + delta5);
        }
        {//2^k-1\2
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h*2;
            h-=1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                insertSort.sort(tab2, h);
                //  System.out.println(h);
                h /= 2;
            }
            Bubblesort bubblesort = new Bubblesort();
            bubblesort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 2/b =" + delta5);
        }
        {//2^k+1\2
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h*2;
            h+=1;

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                insertSort.sort(tab2, h);
                //  System.out.println(h);
                h = h/2;
            }
            Bubblesort bubblesort = new Bubblesort();
            bubblesort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 2/c =" + delta5);
        }
        {//fibonaci\2
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int n = 1;
            int h = 1;
            while (h <= size) h = fib(n++);

            InsertSort insertSort = new InsertSort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                insertSort.sort(tab2, h);
                //  System.out.println(h);
                h = fib(--n);
            }
            Bubblesort bubblesort = new Bubblesort();
            bubblesort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 2/d =" + delta5);
        }
        {//3h+1\3
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = 3*h+1;

            Bubblesort bubblesort = new Bubblesort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                bubblesort.sort(tab2, h);
               // System.out.println(h);
                h /= 3;
            }
            InsertSort insertSort = new InsertSort();
            insertSort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 3/a =" + delta5);
        }

        {//2^k-1\3
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h*2;
            h-=1;

            Bubblesort bubblesort = new Bubblesort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                bubblesort.sort(tab2, h);
                //  System.out.println(h);
                h /= 2;
            }
            InsertSort insertSort = new InsertSort();
            insertSort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 3/b =" + delta5);
        }
        {//2^k+1\3
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int h = 1;
            while (h <= size) h = h*2;
            h+=1;

            Bubblesort bubblesort = new Bubblesort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                bubblesort.sort(tab2, h);
                //  System.out.println(h);
                h = h/2;
            }
            InsertSort insertSort = new InsertSort();
            insertSort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 3/c =" + delta5);
        }
        {//fibonaci\3
            int[] tab2 = new int[size];
            System.arraycopy(tab1, 0, tab2, 0, size);

            int n = 1;
            int h = 1;
            while (h <= size) h = fib(n++);

            Bubblesort bubblesort = new Bubblesort();
            long start = System.currentTimeMillis();
            while (h > 1) {
                bubblesort.sort(tab2, h);
                //  System.out.println(h);
                h = fib(--n);
            }
            InsertSort insertSort = new InsertSort();
            insertSort.sort(tab2,1);
            long stop = System.currentTimeMillis();
            long delta5 = stop - start;
            System.out.println("\nwersja 3/d =" + delta5);
        }
    }
    public static int fib(int n){
        if (n <= 0) {
            return 0;
        } else if ((n==1)||(n==2))
            return 1;
        else
            return fib(n-1)+fib(n-2);

    }
}
