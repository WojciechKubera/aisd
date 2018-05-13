import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Wojtek on 2016-05-17.
 */
public class HashTab<K,V> {
    Comparator<K> comparator;

    public HashTab(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    Object[] tab = new Object[1];
    int size = 0;

    public void insert(K key, V value){
        int index  = Math.abs(key.hashCode())%tab.length;
        while(tab[index]!= null && comparator.compare(((Pair<K,ArrayList<V>>)tab[index]).key,key)!=0){
            index = (index+1)%tab.length;
        }
       if(tab[index]==null){
           tab[index] = new Pair<K,ArrayList<V>>(key, new ArrayList<V>());
           size++;
       }
        ((Pair<K,ArrayList<V>>)tab[index]).value.add(value);

        if (size > tab.length*0.75) {
            resize();
        }
    }

    void resize() {
        Object[] oldTab = tab;

        int big = oldTab.length*2 +1;
        boolean flag = false;
        while (!flag) {

            if (big%2 == 0) {
                flag = true;
            }
            for (int i = 3; i < Math.sqrt(big) && !flag; i+=2) {
                if (big%i == 0) {
                    flag = true;
                }
            }

            if (flag) {
                big += 2;
                flag = false;
            } else {
                flag = true;
            }
        }

        tab = new Object[big];
        for (int i = 0; i < oldTab.length; i++) {
            Pair<K,ArrayList<V>> a = (Pair<K,ArrayList<V>>)oldTab[i];
            if (a != null) {
                for (V b : a.value) {
                    insert(a.key, b);
                }
            }
        }
    }

    public ArrayList<V> wyszukaj(K key){
        int index  = Math.abs(key.hashCode())%tab.length;
        while(tab[index]!= null && comparator.compare(((Pair<K,ArrayList<V>>)tab[index]).key,key)!=0){
            index = (index+1)%tab.length;
        }
        if(tab[index]==null){
            return null;
        }
        return ((Pair<K,ArrayList<V>>)tab[index]).value;
    }


}
