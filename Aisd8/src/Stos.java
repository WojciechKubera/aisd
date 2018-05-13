/**
 * Created by Wojtek on 2016-03-29.
 */
public class Stos<T> extends Kolejka<T> implements Stack<T>  {


    public void Push(T t) {
      Insert(t);
    }

    public T Pop() {
        T tmp = null;
        if (pierwszy == null){
            tmp = null;
        }else if (pierwszy == ostatni){
            tmp = pierwszy.getWartosc();
            pierwszy = null;
            ostatni = null;
        }else {
            tmp = ostatni.getWartosc();
            Element tmr = pierwszy;
            while (tmr.getNastepnnik()!=ostatni){
                tmr = tmr.getNastepnnik();
            }
            tmr.setNastepnnik(null);
            ostatni = tmr;
        }
        return  tmp;

    }

    public T Peek() {
        T tmp = null;
        if (!isEmpty()) {
            tmp = Pop();
            Push(tmp);

        }
        return tmp;
    }
}
