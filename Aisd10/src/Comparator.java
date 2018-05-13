

public class Comparator implements java.util.Comparator<Pair<Integer, Integer>> {

    public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b ){
        return a.getValue().compareTo(b.getValue());
    }

}
