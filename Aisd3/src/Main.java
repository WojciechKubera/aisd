import java.util.Scanner;

/**
 * Created by Wojtek on 2016-03-15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Firma firma = new Firma();
        int input = 0;
        Klient klient = null;
        do{
            System.out.println("1. Stworz Klienta");
            System.out.println("2. Dodaj towar");
            System.out.println("3. Dodaj Klienta");
            System.out.println("4. Zrealizuj zamowenie");
            System.out.println("0. Wyjscie");
            input = Integer.parseInt(sc.nextLine());
            switch (input){
                case 1:{
                    System.out.println("nazwa klienta");
                String nazwa = sc. nextLine();
                    klient = new Klient(nazwa);
                    System.out.println("stworzono klienta");
                } break;
                case 2:{
                    if (klient!= null) {
                        System.out.println("nazwa towaru");
                        String nazwa = sc.nextLine();
                        System.out.println("ilosc towaru");
                        int ilosc = Integer.parseInt(sc.nextLine());
                        klient.Insert(new Towar(nazwa, ilosc));
                        System.out.println("towar dodano");
                    }else {
                        System.out.println("klient nie istnieje");
                    }
                }  break;
                case 3:{
                   if (klient!=null) {
                       firma.dodaj(klient.getNazwa(), klient);
                       System.out.println("kienta dodano");
                       klient = null;
                   }else {
                       System.out.println("klient nie istnieje");
                   }
                } break;
                case  4:{
                    firma.zrealizuj();
                }
            }
        } while (input!= 0);
    }
}
