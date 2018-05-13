/**
 * Created by Wojtek on 2016-03-15.
 */
public class Towar {
    String nazwaTowaru;
    int ilosc;

    public Towar(String nazwaTowaru, int ilosc){
        this.nazwaTowaru = nazwaTowaru;
        this.ilosc = ilosc;
    }
     int getIlosc(){
         return  ilosc;
     }
}
