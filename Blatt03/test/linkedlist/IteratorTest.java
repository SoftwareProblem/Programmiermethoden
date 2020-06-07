package linkedlist;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IteratorTest {

    @Test
    public void testEmptyListHasNext() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        Iterator<Integer> iterator = simpleList.iterator();

        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyListNext() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        Iterator<Integer> iterator = simpleList.iterator();

        iterator.next();
    }

    @Test
    public void testHasNextAfterIteration() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);
        simpleList.add(3);
        simpleList.add(3);

        Iterator<Integer> iterator = simpleList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIterateCompleteList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);
        simpleList.add(3);
        simpleList.add(3);
        simpleList.add(2);
        simpleList.add(4);

        Integer[] results = {10, 3, 3, 2, 4};
        int pos = 0;
        for (Integer i : simpleList) {
            assertEquals(i, results[pos]);
            pos++;
        }

        assertEquals(pos, 5);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextAfterIteration() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);
        simpleList.add(3);
        simpleList.add(3);

        Iterator<Integer> iterator = simpleList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        iterator.next();
    }
}
