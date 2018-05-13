
public class Element {
    Karta karta;
    Element nastepnik = null;

    public Element(Karta karta){
        this.karta = karta;

    }
    void setNastepnik(Element n){
        nastepnik = n;

    }
    Element getNastepnik(){
        return nastepnik;
    }
    Karta getValue(){
        return karta;
    }
}

