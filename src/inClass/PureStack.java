package inClass;

public interface PureStack <E> {
    /**
     * Checks if stack is empty
     * @return - true or false
     */
    boolean empty();

    /**
     * Peeks at first item
     * @return first item
     */
    E peek();

    /**
     * Removes item
     * @return item removed
     */
    E pop();

    /**
     * adds item
     * @param item - item to add
     * @return - item added
     */
    E push(E item);
}
