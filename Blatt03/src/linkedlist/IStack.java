package linkedlist;

import java.util.NoSuchElementException;

public interface IStack<T> {
    /**
     * Appends the given element to the end of the list.
     * <p>
     * Vorgabe
     *
     * @param toAdd the element to be added
     */
    void push(T toAdd);

    /**
     * Removes and returns the last element of the list.
     * <p>
     * Vorgabe
     *
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    T pop() throws NoSuchElementException;
}
