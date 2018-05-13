import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Wojtek on 2016-05-10.
 */
public class Pair <K, V> {
    K key = null;
    V value = null;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    K getKey() {
        return key;
    }
    V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key.toString() + "-" + value.toString();
    }
}
