/**
 * Created by Wojtek on 2016-03-15.
 */
public class Klient extends Kolejka<Towar> {

        String nazwa;

    public Klient(String nazwa){
    this.nazwa = nazwa;
    }
    String getNazwa(){
        return  nazwa;
    }
}
