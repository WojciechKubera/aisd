
public class Lista {

    Element pierwszy = null;

    public Lista() {

    }

    boolean pusta() {
        return (pierwszy == null);
    }

    void dodaj(Karta karta) {
        Element tmp = new Element(karta);
        tmp.setNastepnik(pierwszy);
        pierwszy = tmp;

    }

    void usun(Karta karta) {
        if (!pusta()) {
            Element tmp = pierwszy;
            Element tmpp = pierwszy;
            while (tmp.getNastepnik() != null && !tmp.getValue().equals(karta)) {
                tmpp = tmp;
                tmp = tmp.getNastepnik();
            }
            if (tmp.getValue().equals(karta)) {
                tmpp.setNastepnik(tmp.getNastepnik());
            }
        }
    }

    boolean szukaj(Karta karta) {
        boolean a = false;
        if (!pusta()) {
            Element tmp = pierwszy;
            while (tmp.getNastepnik() != null && !tmp.getValue().equals(karta)) {
                tmp = tmp.getNastepnik();
            }
            if (tmp.getValue().equals(karta)) {
                a = true;
            }
        }
        return a;
    }

    void wyswietl() {

        Element tmp = pierwszy;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNastepnik();
        }

    }

    int liczbaElementow() {
        int suma = 0;
        Element tmp = pierwszy;
        while (tmp != null) {
            suma++;
            tmp = tmp.getNastepnik();
        }
        return suma;
    }

    Element onIndex(int i) {
        int suma = 0;
        Element tmp = pierwszy;
        while (tmp != null && suma != i) {
            suma++;
            tmp = tmp.getNastepnik();
        }
        return tmp;
    }

    void zamien(int i) {
        Element tmp = onIndex(i);
        Element nast = tmp.getNastepnik();
        if (i == 0) {
            pierwszy = nast;
            tmp.setNastepnik(nast.getNastepnik());
            nast.setNastepnik(tmp);
        } else {
            Element pop = onIndex(i - 1);
            pop.setNastepnik(nast);
            tmp.setNastepnik(nast.getNastepnik());
            nast.setNastepnik(tmp);
        }
    }

    void sortowaniePoWartosci() {
        int n = liczbaElementow();
        do {
            for (int i = 0; i < n - 1; i++) {
                if (onIndex(i).getValue().wartosc > onIndex(i + 1).getValue().wartosc) {
                    zamien(i);
                } else if (onIndex(i).getValue().wartosc == onIndex(i + 1).getValue().wartosc
                        && onIndex(i).getValue().kolor > onIndex(i + 1).getValue().kolor) {
                    zamien(i);
                }
            }
            n--;
        } while (n > 1);
    }

    void szukajWarosc(int i) {
        Element tmp = pierwszy;
        while (tmp != null) {
            if (tmp.getValue().wartosc == i) {
                System.out.println(tmp.getValue());
            }
                tmp = tmp.getNastepnik();

        }
    }
    void szukajKolor(int i) {
        Element tmp = pierwszy;
        while (tmp != null) {
            if (tmp.getValue().kolor == i) {
                System.out.println(tmp.getValue());
            }
            tmp = tmp.getNastepnik();
        }
    }
}
