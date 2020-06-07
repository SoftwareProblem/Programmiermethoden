package linkedlist;

import java.util.Comparator;

public interface ISortable<T> {
    /**
     * Sorts the list based on the lexicographical order of its elements.
     *
     * <p>
     * Vorgabe
     */
    void sort();

    /**
     * Sorts the list based on the order specified by the given {@link Comparator}.
     * The comparator has to be of the generic type specified in the list.
     * <p>
     * Vorgabe
     *
     * @param c the {@code Comparator} used to compare list elements.
     */
    void sort(Comparator<? super T> c);
}
