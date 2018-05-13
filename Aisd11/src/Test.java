import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Wojtek on 2016-05-17.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        HashTab<String,String> hashTab = new HashTab(new Comparator());
        BST <String,String> bst = new BST(new Comparator());
       /** String k = "klklk";
        String v1 = "kij";
        String v2 = "jkl";
        bst.insert(k,v1);
        bst.insert(k,v2);
        hashTab.insert(k,v1);
        hashTab.insert(k,v2);
        System.out.println(bst.wyszukaj(k));
        System.out.println(hashTab.wyszukaj(k));**/


        File plik = new File("G:\\lista_11_dane.txt");
        Scanner odczyt = new Scanner(plik);
        StringTokenizer token;
        StringTokenizer token1;
        while (odczyt.hasNextLine()) {
            token = new StringTokenizer(odczyt.nextLine(), "\r\n");
            while(token.hasMoreElements()){
                token1 = new StringTokenizer(token.nextToken(), "\t");
                String v = token1.nextToken();
                while(token1.hasMoreElements()){
                    String k = token1.nextToken();
                    bst.insert(k,v);
                    hashTab.insert(k,v);
                }
            }
        }
        System.out.println(bst.wyszukaj("8ab6766b5b60e28011576b9ee33edf45"));
        System.out.println(hashTab.wyszukaj("8ab6766b5b60e28011576b9ee33edf45"));
    }

}
