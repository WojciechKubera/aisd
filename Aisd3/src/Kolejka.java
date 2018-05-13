/**
 * Created by Wojtek on 2016-03-15.
 */
public class Kolejka<T> implements Queue<T> {
private class Element<T>{
    Element nastepnnik = null;
    T wartosc = null;
     Element(T wartosc){
         this.wartosc = wartosc;
     }
    void setNastepnnik(Element nastepnnik){
       this.nastepnnik = nastepnnik;
    }
    Element getNastepnnik(){
        return nastepnnik;
    }
    T getWartosc(){
        return wartosc;
    }
}


    Element<T> pierwszy = null;
    Element<T>  ostatni = null;



    @Override
    public boolean isEmpty() {
        return (pierwszy==null);
            }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void Insert(T t) {
    Element<T> tmp = new Element(t);
        if (pierwszy == null){
            pierwszy = tmp;
            ostatni = tmp;
        }else {
            ostatni.setNastepnnik(tmp);
            ostatni = tmp;
        }
    }
    @Override
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
        return  tmp;

    }
}
