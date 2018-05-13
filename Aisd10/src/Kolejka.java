import java.util.Comparator;

public class Kolejka<T> {
    public class Element<T>{
        Element<T> nastepnnik = null;
        T wartosc = null;
        Element(T wartosc){
            this.wartosc = wartosc;
        }
        void setNastepnnik(Element<T> nastepnnik){
            this.nastepnnik = nastepnnik;
        }
        Element<T> getNastepnnik(){
            return nastepnnik;
        }
        T getWartosc(){
            return wartosc;
        }

    }

    Element<T> pierwszy = null;
    Element<T>  ostatni = null;
    int size = 0;



    public boolean isEmpty() {
        return (pierwszy==null);
    }


    public boolean isFull() {
        return false;
    }




    public void Insert(T t) {
        Element<T> tmp = new Element(t);
        if (pierwszy == null){
            pierwszy = tmp;
            ostatni = tmp;
        }else {
            Element<T> z = pierwszy;
            while (z.getNastepnnik()!= null && z.getNastepnnik().getNastepnnik()!= null && comparator.compare(t,z.getNastepnnik().getWartosc())<0  ) {
                z = z.getNastepnnik();
            }
            if (z == pierwszy && comparator.compare(t,z.getWartosc())>0) {
                tmp.setNastepnnik(z);
                pierwszy = tmp;
            }else if (z.getNastepnnik()!= null && comparator.compare(t,z.getNastepnnik().getWartosc())>0){
                tmp.setNastepnnik(z.getNastepnnik());
                z.setNastepnnik(tmp);
            }else{
                ostatni.setNastepnnik(tmp);
                ostatni = tmp;
            }
        }
        size++;
         }


    public T Remove() {
        T tmp = null;
        if (pierwszy == null){
            tmp = null;
        }else if (pierwszy == ostatni){
            tmp = pierwszy.getWartosc();
            pierwszy = null;
            ostatni = null;
        }else {
            tmp = pierwszy.getWartosc();
            pierwszy = pierwszy.getNastepnnik();
        }
        size--;
        return  tmp;

    }
    Comparator<T> comparator;
    public Kolejka(Comparator<T> comparator){
        this.comparator = comparator;

    }
   public String toString(){
       String s= "";
       Element<T> z = pierwszy;
       while (z!= null ) {
           s += z.getWartosc()+" ";
           z = z.getNastepnnik();

       }
       return"kolejka "+ s+" ";
   }
}