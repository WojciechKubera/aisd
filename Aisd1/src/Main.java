import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
//import java.util.*;

/**
 * Created by Wojtek on 2016-03-02.
 */
public class Main {

    public static void main(String args[]) {
        Main tmp = new Main();
        tmp.czytaj();
        tmp.wyswietl();
        //tmp.zapisz();

    }

    Pracownik[] tab;
    int li  = 0;

    public Main() {

    }
    void wczytaj(){

        Scanner skaner = new Scanner(System.in);
        System.out.println("iloscPracownikow");
        int l = skaner.nextInt();
        tab = new Pracownik[l];
        for (int j = 0 ; j<l ; j++){
            System.out.println("nazwisko:");
            String n = skaner.next();
            System.out.println("imie:");
            String i =  skaner.next();
            System.out.println("pesel:");
            long p = skaner.nextLong();
            System.out.println("staz:");
            int s = skaner.nextInt();
            System.out.println("pensja:");
            double pe = skaner.nextDouble();
            tab[li] = new Pracownik(n,i,p,s,pe);
            li++;
            System.out.println("--------------------");
        }
    }
    void wyswietl(){
        System.out.println(String.format(String.format("%%%ds", 69), " ").replace(" ", "-"));
        System.out.printf("I %-15s I %-15s I %-11s I %-4s I %-8s I\n", "Nazwisko","Imie","Pesel","Staz","Pensja");
        System.out.println(String.format(String.format("%%%ds", 69), " ").replace(" ", "-"));
        for(int i = 0; i<li ; i++)
            tab[i].wyswietl();


        System.out.println(String.format(String.format("%%%ds", 69), " ").replace(" ", "-"));
    }
    void czytaj(){
        try {
            FileInputStream fis = new FileInputStream("plik.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
          int lix = ois.readInt();
            tab = new Pracownik[lix];
            li = lix;
            for(int i = 0; i<lix; i++){
              tab[i] = (Pracownik)ois.readObject();
            }
            ois.close();
        }catch (Exception e){System.out.println("blad");}

    }

    void zapisz() {
        try {
            FileOutputStream fos = new FileOutputStream("plik.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(li);
            for(int i = 0; i<li; i++){
                oos.writeObject(tab[i]);
            }
           oos.close();

        }catch(Exception e){System.out.println("blad");}
    }

}

