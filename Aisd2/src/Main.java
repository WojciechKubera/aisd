import java.util.Random;

/**
 * Created by Wojtek on 2016-03-08.
 */
public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        Karta a = new Karta(7,3);
        l.dodaj(a);

        Random losowanieKart = new Random();
        while(true) {
            int wartosc = losowanieKart.nextInt(15);
            int kolor = losowanieKart.nextInt(4);
            if (wartosc == 0) {
                break;
            }
            l.dodaj( new Karta(wartosc,kolor));
        }
        System.out.println(l.liczbaElementow());
        System.out.println(l.szukaj(a));
        l.wyswietl();

        System.out.println();
        l.szukajWarosc(7);
        l.szukajKolor(3);
        l.sortowaniePoWartosci();
        l.usun(a);
        l.wyswietl();
    }
}
