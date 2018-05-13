import java.io.PrintStream;
import java.io.Serializable;

/**
 * Created by Wojtek on 2016-03-02.
 */
public class Pracownik implements Serializable {

    String nazwisko;
    String imie;
    long pesel;
    int staz;
    double pensja;

    public Pracownik( String nazwisko,String imie, long pesel,int staz, double pensja){

        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pensja = pensja;
        this.staz = staz;
        this.pesel = pesel;

    }

    public String toString(){

        return String.format("%s, %s, %d, %d, %.2f", nazwisko, imie, pesel, staz, pensja);

    }
    void wyswietl() {

        System.out.printf("I %-15s I %-15s I %11d I %4d I %8.2f I\n", nazwisko, imie, pesel, staz, pensja);

    }
}
