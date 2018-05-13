import java.util.List;

/**
 * Created by Wojtek on 2016-04-05.
 */
public abstract class Lista<T> {
    public class Element<T>{
        int nrWiersza;
        int nrKolumny;
        Element nastepnyWiersz = null;
        Element nastepnaKolumna = null;
        T wartosc = null;
        Element(int nrWiersza, int nrKolumny,T wartosc){
            this.wartosc = wartosc;
            this.nrWiersza = nrWiersza;
            this.nrKolumny = nrKolumny;
        }
        void setNastepnaKolumna(Element nastepnaKolumna){
            this.nastepnaKolumna = nastepnaKolumna;
        }
        void setNastepnyWiersz(Element nastepnyWiersz){
            this.nastepnyWiersz = nastepnyWiersz;
        }
        Element getNastepnaKolumna(){
            return nastepnaKolumna;
        }
        Element getNastepnaWiersz(){
            return nastepnyWiersz;
        }
        void setWartosc(T wartosc){
            this.wartosc =wartosc;
        }
        T getWartosc(){
            return wartosc;
        }
        int getNrWiersza(){
            return nrWiersza;
        }
        int getNrKolumny(){
            return nrKolumny;
        }

    }

    Element<T> pierwszy = new Element<>(0,0,null);


    public boolean isEmpty() {
        return (pierwszy.getNastepnaKolumna()==null)&&(pierwszy.getNastepnaWiersz()==null);
    }

    public void Load (Object[][] array) {
        T[][] tArray = (T[][])array;
        int wiersze = tArray.length;
        int kolumny = (wiersze != 0? tArray[0].length : 0);

        Element<T> wierszeOstatnie[] = new Element[wiersze+1];
        wierszeOstatnie[0] = pierwszy;
        Element<T> kolumnyOstatnie[] = new Element[kolumny+1];
        kolumnyOstatnie[0] = pierwszy;

        for (int i = 0; i < wiersze; i++) {
            Element wie = new Element(i+1, 0, null);
            wierszeOstatnie[i].setNastepnyWiersz(wie);
            wierszeOstatnie[i+1] = wie;
        }

        for (int i = 0; i < kolumny; i++) {
            Element kol = new Element(0, i+1, null);
            kolumnyOstatnie[i].setNastepnaKolumna(kol);
            kolumnyOstatnie[i+1] = kol;
        }

        Element<T> wierszeOstatnieGlowa = pierwszy;

        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                if (!test(tArray[i][j])) {
                    Element war = new Element(i+1, j+1, tArray[i][j]);
                    wierszeOstatnie[i+1].setNastepnaKolumna(war);
                    wierszeOstatnie[i+1] = war;
                    kolumnyOstatnie[j+1].setNastepnyWiersz(war);
                    kolumnyOstatnie[j+1] = war;
                }
            }
        }
    }

    // definiowane prze uzytkowinka
    T testSubject = null;
    void setTestSubject(T testSubject) {
        this.testSubject = testSubject;
    }
    boolean test(T wartosc) {
        return testSubject.equals(wartosc);
    }

    void dodawanie(Lista<T> skladnik) {
        Element<T> aGlowa = pierwszy.getNastepnaKolumna();
        Element<T> bGlowa = skladnik.pierwszy.getNastepnaKolumna();
        Element<T> aKolumna = aGlowa;
        Element<T> bKolumna = bGlowa;

        while (aGlowa != null) {

            while (bKolumna != null) {

                int ostatniPrzekopiowanyWiersz = 0;
                while (aKolumna.getNrWiersza() != bKolumna.getNrWiersza()) {

                    if (aKolumna.getNastepnaWiersz() != null) {

                        if (aKolumna.getNrWiersza() < bKolumna.getNrWiersza()
                                && aKolumna.getNastepnaWiersz().getNrWiersza() > bKolumna.getNrWiersza()) {
                            Element tmp = new Element(bKolumna.getNrWiersza(), aKolumna.getNrKolumny(), bKolumna.getWartosc());
                            tmp.setNastepnyWiersz(aKolumna.getNastepnaWiersz());
                            aKolumna.setNastepnyWiersz(tmp);
                            aKolumna = aKolumna.getNastepnaWiersz();
                            ostatniPrzekopiowanyWiersz = aKolumna.getNrWiersza();
                        } else {
                            aKolumna = aKolumna.getNastepnaWiersz();
                        }

                    } else {
                        Element tmp = new Element(bKolumna.getNrWiersza(), aKolumna.getNrKolumny(), bKolumna.getWartosc());
                        aKolumna.setNastepnyWiersz(tmp);
                        aKolumna = aKolumna.getNastepnaWiersz();
                        ostatniPrzekopiowanyWiersz = tmp.getNrWiersza();
                    }
                }

                if (ostatniPrzekopiowanyWiersz != aKolumna.getNrWiersza()) {
                    aKolumna.setWartosc(sum(aKolumna.getWartosc(), bKolumna.getWartosc()));
                }
                bKolumna = bKolumna.getNastepnaWiersz();
            }

            aKolumna = aGlowa.getNastepnaKolumna();
            aGlowa = aGlowa.getNastepnaKolumna();
            bKolumna = bGlowa.getNastepnaKolumna();
            bGlowa= bGlowa.getNastepnaKolumna();
        }
    }

    // definiowane przez uzytkownika
    abstract T sum(T a, T b);

    T[][] toArray() {
        Element<T> wierszOstatni = pierwszy;
        while (wierszOstatni.getNastepnaWiersz() != null){
            wierszOstatni = wierszOstatni.getNastepnaWiersz();
        }
        int wiersze = wierszOstatni.getNrWiersza();

        Element<T> kolumnaOstatnia = pierwszy;
        while (kolumnaOstatnia.getNastepnaKolumna() != null){
            kolumnaOstatnia = kolumnaOstatnia.getNastepnaKolumna();
        }
        int kolumny = kolumnaOstatnia.getNrKolumny();

        Object[][] tArray = new Object[wiersze][kolumny];

        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                tArray[i][j] = testSubject;
            }
        }

        Element<T> glowa = pierwszy.getNastepnaKolumna();
        int kol = 0;
        Element<T> kolumna = glowa;
        while (glowa != null) {
            while (kolumna.getNastepnaWiersz() != null) {
                kolumna = kolumna.getNastepnaWiersz();
                tArray[kolumna.getNrWiersza()-1][kol] = kolumna.getWartosc();
            }

            kol++;
            kolumna = glowa.getNastepnaKolumna();
            glowa = glowa.getNastepnaKolumna();
        }

        return (T[][])tArray;
    }

}
