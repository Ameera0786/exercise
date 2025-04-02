package inClass;

import java.util.*;

/**
 * Queue implementation
 * @param <E> - generic type
 */
public class TheQueue<E> implements Queue<E> {
    private static final int MAX = 10;
    private final List<E> data = new TheLinkedList<>();
    @Override
    public boolean add(E e) throws IllegalStateException, NullPointerException {
        if (data.size() == MAX) {
            throw new IllegalStateException("Queue is full");
        }
        data.addLast(Objects.requireNonNull(e));
        return true;
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data.removeFirst();
    }

    @Override
    public E poll() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data.removeFirst();
    }

    @Override
    public E element() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data.getFirst();
    }

    @Override
    public E peek() {
        E returnItem;
        if (isEmpty()) {
            returnItem = null;
        } else {
            returnItem = data.getFirst();
        }
        return returnItem;
    }
    @Override
    public boolean offer(E e) throws IllegalStateException,
            NullPointerException {
        boolean addable = data.size() != MAX;
        if (addable) {
            data.addLast(Objects.requireNonNull(e));
        }
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

}
