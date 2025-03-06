package inClass;

import java.util.*;

public class TheArrayList<E> implements List<E> {
    //backing data structure is an array
    private class TheIterator implements Iterator<E> {
        private int lastReturned;

        @Override
        public boolean hasNext() {
            return lastReturned < size();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return data[lastReturned++];
        }

        @Override
        public void remove() throws IllegalStateException {
            if (lastReturned == -1) {
                throw new IllegalStateException();
            }
            TheArrayList.this.remove(lastReturned);
            lastReturned = -1;
            --lastReturned;
        }
    }
    private E[] data;
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private int capacity;

    public TheArrayList() {
        size = 0;
        capacity = INITIAL_CAPACITY;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean contained = false;
        for (int i = 0; i < size && !contained; i++) {
            if (data[i].equals(o)) {
                contained = true;
            }
        }
        return contained;
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
    public boolean add(E e) {
        if (size == capacity) {
            reallocate();
        }
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        for (int i = 0; i < size && !removed; i++) {
            if (data[i].equals(o)) {
                for (int j = i + 1; j < size; j++) {
                    data[j - 1] = data[j];
                    removed = true;
                }
                
            }
        }
        return removed;
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
    public boolean addAll(int index, Collection<? extends E> c) {
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
        size = 0;
        
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        validateIndex(index);
        return data[index];
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E old = data[index];
        data[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        validateIndex(index);
        if (size == capacity) {
            reallocate();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E old = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    public void reallocate() {
        capacity = capacity * 2;
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
