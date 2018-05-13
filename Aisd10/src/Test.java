import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Wojtek on 2016-05-10.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Kolejka< Pair<Integer, Integer>> kolejka = new Kolejka(new Comparator());
        MaxPQ< Pair<Integer, Integer>> pq = new MaxPQ(new Comparator());
        /** kolejka.Insert(new Pair<Integer, Integer>(13,1));
         kolejka.Insert(new Pair<Integer, Integer>(1,2));
         kolejka.Insert(new Pair<Integer, Integer>(10,3));
         kolejka.Insert(new Pair<Integer, Integer>(12,4));
         kolejka.Remove();

         System.out.println(kolejka);

         pq.insert(new Pair<Integer, Integer>(13,3));
         pq.insert(new Pair<Integer, Integer>(9,2));
         pq.insert(new Pair<Integer, Integer>(12,7));
         pq.insert(new Pair<Integer, Integer>(4,8));
         pq.insert(new Pair<Integer, Integer>(8,9));
         System.out.println(pq.delMax());
         **/
        File plik = new File("G:\\Aisd.txt");
        Scanner odczyt = new Scanner(plik);
        StringTokenizer token;
        while (odczyt.hasNextLine()){
            token = new StringTokenizer(odczyt.nextLine()," ");
            while(token.hasMoreElements()){
                 kolejka.Insert(new Pair<>(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken())));
               // pq.insert(new Pair<>(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken())));


            }

        }
        while (!kolejka.isEmpty()){
            System.out.println(kolejka.pierwszy.getWartosc());
            kolejka.Remove();
        }
       // while(!pq.isEmpty()){
        //    System.out.println( pq.max());
        //    pq.delMax();
      //  }


    }
}