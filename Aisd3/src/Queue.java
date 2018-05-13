/**
 * Created by Wojtek on 2016-03-15.
 */
public interface Queue<T> {

    public boolean isEmpty();
    public boolean isFull();
    void Insert(T t);
    T Remove();


}
