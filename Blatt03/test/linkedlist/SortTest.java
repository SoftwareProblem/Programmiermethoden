package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortTest {

    @Test
    public void testSort() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);
        simpleList.add(3);
        simpleList.add(6);
        simpleList.add(2);
        simpleList.add(4);

        simpleList.sort();

        assertEquals(2, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(4, simpleList.get(2).intValue());
        assertEquals(6, simpleList.get(3).intValue());
        assertEquals(10, simpleList.get(4).intValue());
    }

    @Test
    public void testSortEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.sort();

        assertTrue(simpleList.isEmpty());
    }

    @Test
    public void testSortListElementsWithAllSameValues() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        Integer integer1 = 10;
        Integer integer2 = 10;
        Integer integer3 = 10;
        Integer integer4 = 10;

        simpleList.add(integer1);
        simpleList.add(integer2);
        simpleList.add(integer3);
        simpleList.add(integer4);

        simpleList.sort();

        assertEquals(4, simpleList.size());
        assertEquals(integer1, simpleList.get(0));
        assertEquals(integer2, simpleList.get(1));
        assertEquals(integer3, simpleList.get(2));
        assertEquals(integer4, simpleList.get(3));
    }

    @Test
    public void testSortListOneElement() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.add(10);

        simpleList.sort();

        assertEquals(1, simpleList.size());
        assertEquals(10, simpleList.get(0).intValue());
    }

    @Test
    public void testSortListSomeElementsWithSomeSameValues() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        Integer integer1 = 8;
        Integer integer2 = 10;
        Integer integer3 = 9;
        Integer integer4 = 7;

        simpleList.add(integer1);
        simpleList.add(integer2);
        simpleList.add(integer3);
        simpleList.add(integer4);

        simpleList.sort();

        assertEquals(4, simpleList.size());
        assertEquals(integer4, simpleList.get(0));
        assertEquals(integer1, simpleList.get(1));
        assertEquals(integer3, simpleList.get(2));
        assertEquals(integer2, simpleList.get(3));
    }

    @Test
    public void testSortListUsingComparator() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        Integer integer1 = 8;
        Integer integer2 = 10;
        Integer integer3 = 10;
        Integer integer4 = 7;

        simpleList.add(integer1);
        simpleList.add(integer2);
        simpleList.add(integer3);
        simpleList.add(integer4);

        simpleList.sort((o1, o2) -> o2 - o1);

        assertEquals(4, simpleList.size());
        assertEquals(10, simpleList.get(0).intValue());
        assertEquals(10, simpleList.get(1).intValue());
        assertEquals(8, simpleList.get(2).intValue());
        assertEquals(7, simpleList.get(3).intValue());
    }
}
