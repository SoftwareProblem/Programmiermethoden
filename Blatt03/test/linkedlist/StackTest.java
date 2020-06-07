package linkedlist;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {

    @Test
    public void testPush() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.push(5);
        simpleList.push(6);

        assertEquals(2, simpleList.size());
        assertEquals(5, simpleList.get(0).intValue());
        assertEquals(6, simpleList.get(1).intValue());
    }

    @Test
    public void testPushNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.push(5);
        simpleList.push(null);
        simpleList.push(6);

        assertEquals(5, simpleList.get(0).intValue());
        assertNull(simpleList.get(1));
        assertEquals(6, simpleList.get(2).intValue());
    }

    @Test
    public void testPop() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(42);
        simpleList.add(1337);
        simpleList.add(666);

        assertEquals(3, simpleList.size());
        Integer x1 = simpleList.pop();
        assertEquals(2, simpleList.size());
        Integer x2 = simpleList.pop();
        assertEquals(1, simpleList.size());
        Integer x3 = simpleList.pop();
        assertEquals(0, simpleList.size());

        assertEquals(666, x1.intValue());
        assertEquals(1337, x2.intValue());
        assertEquals(42, x3.intValue());
    }

    @Test
    public void testPopOne() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(42);

        assertEquals(1, simpleList.size());
        Integer x = simpleList.pop();
        assertEquals(0, simpleList.size());

        assertEquals(42, x.intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopAfterEmpty() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.push(42);
        simpleList.pop();

        simpleList.pop();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.pop();
    }
}
