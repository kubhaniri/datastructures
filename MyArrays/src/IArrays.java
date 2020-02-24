public interface IArrays<E> {

    public void addFirst(E objE);

    public void addLast(E objE);

    public E removeFirst();

    public E removeLast();

    public E remove(E objE);

    public boolean contains(E objE);

    public E peekFirst();

    public E peekLast();
    public int getCurrentSize();
}
