import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Wojtek on 2016-05-17.
 */
public class BST<K,V> {

    class Node<K, V> {
        ArrayList<V> values = new ArrayList<V>();
        K key;
        Node right;
        Node left;


        public Node(K key) {
            this.key = key;
        }

    }

    Node root;
    Comparator<K> comparator;

    public BST(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public void insert(K key, V value) {
        root = insert(key, value, root);
    }

    private Node insert(K key, V value, Node<K, V> t) {
        if (t == null) {
            t = new Node(key);
            t.values.add(value);
        } else {
            int i = comparator.compare(key, t.key);
            if (i < 0) {
                t.left = insert(key, value, t.left);
            } else if (i > 0) {
                t.right = insert(key, value, t.right);
            } else {
                t.values.add(value);
            }
        }
        return t;
    }
    public ArrayList<V> wyszukaj(K key){
        Node<K,V> t = wyszukaj(key, root);
        if(t != null){
            return t.values;
        }
        return null;
    }

    private Node<K, V> wyszukaj(K key,  Node<K, V> t){
        if ( t!=null) {
            int i = comparator.compare(key, t.key);
            if (i < 0) {
                t.left = wyszukaj(key, t.left);
            } else if (i > 0) {
                t.right = wyszukaj(key, t.right);
            }
        }
        return t;
    }
}



