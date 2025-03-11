package inClass;


import java.util.EmptyStackException;
import java.util.List;

public class TheStack<E> implements PureStack<E> {
    private final List<E> data;

    /**
     * Initializes data. Constructor
     */
    public TheStack() {
        data = new TheLinkedList<>();
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public E peek() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.getFirst();
    }

    @Override
    public E pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.removeFirst();
    }

    @Override
    public E push(E item) {
        data.addFirst(item);
        return item;
    }
}
