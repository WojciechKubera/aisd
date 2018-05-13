
public class Karta {

    int wartosc;
    int kolor;

    public Karta(){
        kolor=0;
        wartosc=1;

    }
    public Karta(int wartosc, int kolor){
        this.wartosc = wartosc;
        this.kolor = kolor;
    }
    @Override
   public String toString(){
        return String.format("karta: %d %d",wartosc, kolor );
    }
    @Override
    public  boolean equals(Object o){
        if(o!=null && o instanceof Karta){
            Karta k =(Karta)o;
            if(wartosc == k.wartosc
                    && kolor == k.kolor){
                return true;
            }
        }
        return  false;
    }
}

