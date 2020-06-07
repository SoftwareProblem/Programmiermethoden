package linkedlist;

import java.util.NoSuchElementException;

public interface ISimpleList<T> {
    /**
     * Appends the specified element to the end of the list.
     * <p>
     * Vorgabe
     *
     * @param toAdd the element to be appended to the list
     */
    void add(T toAdd);

    /**
     * Inserts the given element at the specified position in the list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     * <p>
     * Vorgabe
     *
     * @param index index at which the specified element is to be inserted
     * @param toAdd element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void add(int index, T toAdd) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at the specified position in the list with the
     * specified element.
     * <p>
     * Vorgabe
     *
     * @param index index of the element to replace
     * @param toSet element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    void set(int index, T toSet) throws IndexOutOfBoundsException;

    /**
     * Appends all of the elements from a collection to the list.
     * <p>
     * Vorgabe
     *
     * @param collection the list from which the elements should be added.
     * @throws NullPointerException if the specified collection is null
     */
    void addAll(Iterable<T> collection) throws NullPointerException;

    /**
     * Removes the first occurrence of the specified element from the list, if
     * it is present. If the list does not contain the element, nothing is
     * changed.
     * <p>
     * Vorgabe
     *
     * @param toSearch element to search for in the list
     * @return the removed element
     */
    T remove(T toSearch);


    /**
     * Removes the element at the specified position. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * <p>
     * Vorgabe
     *
     * @param index the index of the element to be removed
     * @return the removed element
     * @throws IndexOutOfBoundsException thrown if the index is out of range (index < 0 || index >= size())
     */
    T remove(int index) throws IndexOutOfBoundsException;

    /**
     * Removes all elements from the list.
     * The list is empty after this operation has finished.
     * <p>
     * Vorgabe
     */
    void clear();

    /**
     * Returns true if the list contains the given object.
     * <p>
     * Vorgabe
     *
     * @param toSearch the element the list should contain
     * @return true if object is in list, else false
     */
    boolean contains(T toSearch);

    /**
     * Returns the index of the first occurrence of the specified element in
     * the list, or -1 if the list does not contain the element.
     * <p>
     * Vorgabe
     *
     * @param toFind the element searched for
     * @return the index of the first occurrence of the object in the list (or
     * -1).
     */
    int indexOf(T toFind);

    /**
     * Returns the element at the specified position in the list.
     * <p>
     * Vorgabe
     *
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     * @throws NoSuchElementException    if the list is empty
     */
    T get(int index) throws IndexOutOfBoundsException,
        NoSuchElementException;

    /**
     * Returns the first element
     * <p>
     * Vorgabe
     *
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    T getFirst();

    /**
     * Returns the last element
     * <p>
     * Vorgabe
     *
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    T getLast();

    /**
     * Checks if the list is empty. True if the list is empty, false if it contains elements.
     * <p>
     * Vorgabe
     *
     * @return true if list is empty, false if it contains elements
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     * <p>
     * Vorgabe
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Returns a sublist of the list starting and ending at given indices.
     * <p>
     * If fromIndex (inclusive) and toIndex (inclusive) are equal an empty list is returned.
     * <p>
     * The returned list is backed by this list, so non-structural changes in
     * the returned list are reflected in this list, and vice-versa. The
     * returned list supports all of the optional list operations supported by
     * this list
     * <p>
     * Vorgabe
     *
     * @param fromIndex start of the subList
     * @param toIndex   end of the subList
     * @return the specified subList
     * @throws IndexOutOfBoundsException for an illegal endpoint index value (fromIndex < 0 || toIndex >= size)
     * @throws IllegalArgumentException  for toIndex < fromIndex
     */
    ISimpleList<T> subList(int fromIndex, int toIndex)
        throws IndexOutOfBoundsException, IllegalArgumentException;
}
