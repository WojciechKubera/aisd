/**
 * Created by Wojtek on 2016-03-29.
 */
public interface Stack<T> {

    public boolean isEmpty();
    void Push(T t);
    T Pop();
    T Peek();

}
