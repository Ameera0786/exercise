package inClass;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TheLinkedList<E> implements List<E> {
    private class TheIterator implements Iterator<E> {
        private Node<E> next;
        private E lastReturned;

        private TheIterator() {
            this.next = head;
            this.lastReturned = null;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            lastReturned = next.element;
            next = next.next;
            return lastReturned;
        }

        public void remove() throws IllegalStateException {
//            Iterator.super.remove();
            if (lastReturned == null){
                throw new IllegalStateException();
            }
            TheLinkedList.this.remove(lastReturned);
            lastReturned = null;

        }
    }
    private Node<E> head;
    private int size;

    public TheLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current.next != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
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
    public boolean add(E e) {
        // O(n)
        if (head == null) {
            head = new Node<>(e);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(e);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if (head == null || size == 0) {
            return false;
        }

        if (head.element.equals(o)) {
            head = head.next;
            removed = true;
        } else {
            Node<E> current = head;
            while (current.next != null && !removed) {
                if (current.next.element.equals(o)) {
                    current.next = current.next.next;
                    removed = true;
                }
                current = current.next;
            }
            if (removed) {
                size++;
            }
        }
        return true;
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
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> current = geteNode(index);
        return current.element;
    }

    private Node<E> geteNode(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("invalid index " + index);
        }
    }

    @Override
    public E set(int index, E element) {
        Node<E> current = geteNode(index);
        E old = current.element;
        current.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = geteNode(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
    }

    @Override
    public E remove(int index) {
        return null;
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

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node(E element) {
            this(element, null);
        }
        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}