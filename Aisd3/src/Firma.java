/**
 * Created by Wojtek on 2016-03-15.
 */
public class Firma {
    Kolejka<Klient> magazyn = new Kolejka<>();
    public Firma(){
    }

    void  dodaj(String nazwa, Klient klient){
        magazyn.Insert(klient);
    }
    void zrealizuj(){
        Klient tmp =  magazyn.Remove();
        if(tmp!=null) {
            int suma = 0;
            while (!tmp.isEmpty()) {
                Towar tow = tmp.Remove();
                suma += tow.getIlosc();

            }
            System.out.println(tmp.getNazwa() + ": zlecenie zrealizowane " + suma);
        }else {
            System.out.println("brak klientow");
        }
    }
}
