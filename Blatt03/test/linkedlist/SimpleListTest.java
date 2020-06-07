package linkedlist;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleListTest {

    @Test
    public void testAddAllEmptyListIntoNonEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> dummySimpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        simpleList.addAll(dummySimpleList);

        assertEquals(3, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(3, simpleList.get(2).intValue());
    }

    @Test
    public void testAddAllIntoEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> dummySimpleList = new SimpleLinkedList<>();

        dummySimpleList.add(2);
        dummySimpleList.add(3);
        dummySimpleList.add(4);

        simpleList.addAll(dummySimpleList);

        assertEquals(3, simpleList.size());
        assertEquals(2, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(4, simpleList.get(2).intValue());
    }

    @Test
    public void testAddAllIntoNonEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> dummySimpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        dummySimpleList.add(2);
        dummySimpleList.add(3);
        dummySimpleList.add(4);

        simpleList.addAll(dummySimpleList);

        assertEquals(6, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(3, simpleList.get(2).intValue());
        assertEquals(2, simpleList.get(3).intValue());
        assertEquals(3, simpleList.get(4).intValue());
        assertEquals(4, simpleList.get(5).intValue());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.addAll(null);
    }

    @Test
    public void testAddAtEnd() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add(1, "bcd");

        assertEquals(2, simpleList.size());
        assertSame("abc", simpleList.get(0));
        assertSame("bcd", simpleList.get(1));
    }

    @Test
    public void testAddAtMiddle() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add("bcd");
        simpleList.add("cde");
        simpleList.add("def");
        simpleList.add(2, "efg");

        assertEquals(5, simpleList.size());
        assertSame("abc", simpleList.get(0));
        assertSame("bcd", simpleList.get(1));
        assertSame("efg", simpleList.get(2));
        assertSame("cde", simpleList.get(3));
        assertSame("def", simpleList.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtNegIndex() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add(-1, "abc");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtToLargeIndex() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add(2, "bcd");
    }

    @Test
    public void testAddAtZeroEmptyList() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add(0, "abc");

        assertEquals(1, simpleList.size());
        assertSame("abc", simpleList.get(0));
    }

    @Test
    public void testAddAtZeroNonEmptyList() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add(0, "bcd");

        assertEquals(2, simpleList.size());
        assertSame("bcd", simpleList.get(0));
        assertSame("abc", simpleList.get(1));
    }

    @Test
    public void testAddElement() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");

        assertEquals(1, simpleList.size());
        assertSame("abc", simpleList.get(0));
    }

    @Test
    public void testAddThreeAndNullElements() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add("bcd");
        simpleList.add("cde");
        simpleList.add(null);

        assertEquals(4, simpleList.size());
        assertSame("abc", simpleList.get(0));
        assertSame("bcd", simpleList.get(1));
        assertSame("cde", simpleList.get(2));
        assertNull(simpleList.get(3));
    }

    @Test
    public void testAddThreeElements() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add("bcd");
        simpleList.add("cde");

        assertEquals(3, simpleList.size());
        assertSame("abc", simpleList.get(0));
        assertSame("bcd", simpleList.get(1));
        assertSame("cde", simpleList.get(2));
    }

    @Test
    public void testAddTwoElements() {
        SimpleLinkedList<String> simpleList = new SimpleLinkedList<>();

        simpleList.add("abc");
        simpleList.add("bcd");

        assertEquals(2, simpleList.size());
        assertSame("abc", simpleList.get(0));
        assertSame("bcd", simpleList.get(1));
    }

    @Test
    public void testClearEmptyList() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.clear();

        assertTrue(simpleList.isEmpty());
    }

    @Test
    public void testContainsEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        assertFalse(simpleList.contains(1));
    }

    @Test
    public void testContainsNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        assertFalse(simpleList.contains(null));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtNegIndex() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(4);
        simpleList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtToLargeIndex() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(0);
        simpleList.add(1);

        simpleList.get(2);
    }

    @Test
    public void testClear() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);

        simpleList.clear();

        assertTrue(simpleList.isEmpty());
    }

    @Test
    public void testContainsFalse() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertFalse(simpleList.contains(-1));
    }

    @Test
    public void testContainsTrueEnd() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertTrue(simpleList.contains(3));
    }

    @Test
    public void testContainsTrueMiddle() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertTrue(simpleList.contains(2));
    }

    @Test
    public void testContainsTrueStart() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertTrue(simpleList.contains(1));
    }

    @Test
    public void testGetAtIndex() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(0);
        simpleList.add(3);
        simpleList.add(5);

        assertEquals(0, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(5, simpleList.get(2).intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetAtZeroEmptyList() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.get(0);
    }

    @Test
    public void testGetFirst() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(42);
        simpleList.add(1337);

        assertEquals(42, simpleList.getFirst().intValue());

        simpleList.add(666);
        assertEquals(42, simpleList.getFirst().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstEmptyList() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.getFirst();
    }

    @Test
    public void testGetLast() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(42);
        simpleList.add(1337);
        assertEquals(1337, simpleList.getLast().intValue());

        simpleList.add(666);
        assertEquals(666, simpleList.getLast().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastEmptyList() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.getLast();
    }

    @Test
    public void testIndexOfEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        assertEquals(-1, simpleList.indexOf(1));
    }

    @Test
    public void testIndexOfFalse() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);

        assertEquals(-1, simpleList.indexOf(3));
    }

    @Test
    public void testIndexOfNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);

        assertEquals(-1, simpleList.indexOf(null));
    }

    @Test
    public void testIndexOfTrueEnd() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertEquals(2, simpleList.indexOf(3));
    }

    @Test
    public void testIndexOfTrueMiddle() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertEquals(1, simpleList.indexOf(2));
    }

    @Test
    public void testIndexOfTrueStart() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        assertEquals(0, simpleList.indexOf(1));
    }

    @Test
    public void testIsEmptyFalse() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);

        assertFalse(simpleList.isEmpty());
    }

    @Test
    public void testIsEmptyTrue() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        assertTrue(simpleList.isEmpty());
    }

    @Test
    public void testRemoveAtIndexEnd() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(4);

        assertEquals(5, x.intValue());
        assertEquals(4, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(3, simpleList.get(2).intValue());
        assertEquals(4, simpleList.get(3).intValue());
    }

    @Test
    public void testRemoveAtIndexMiddle() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(2);

        assertEquals(3, x.intValue());
        assertEquals(4, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(4, simpleList.get(2).intValue());
        assertEquals(5, simpleList.get(3).intValue());
    }

    @Test
    public void testRemoveAtIndexStart() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(0);

        assertEquals(1, x.intValue());
        assertEquals(4, simpleList.size());
        assertEquals(2, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(4, simpleList.get(2).intValue());
        assertEquals(5, simpleList.get(3).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtNegIndex() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtToLargeIndex() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);

        simpleList.remove(2);
    }

    @Test
    public void testRemoveByObject() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(new Integer(4));

        assertEquals(4, x.intValue());
        assertEquals(4, simpleList.size());
        assertEquals(0, simpleList.indexOf(1));
        assertEquals(1, simpleList.indexOf(2));
        assertEquals(2, simpleList.indexOf(3));
        assertEquals(3, simpleList.indexOf(5));
    }

    @Test
    public void testRemoveByObjectEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        Integer x = simpleList.remove(new Integer(4));

        assertNull(x);
        assertTrue(simpleList.isEmpty());
    }

    @Test
    public void testRemoveByObjectFirstOccurrence() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(4);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(new Integer(4));

        assertEquals(4, x.intValue());
        assertEquals(5, simpleList.size());
        assertEquals(0, simpleList.indexOf(1));
        assertEquals(1, simpleList.indexOf(2));
        assertEquals(2, simpleList.indexOf(3));
        assertEquals(3, simpleList.indexOf(4));
        assertEquals(4, simpleList.indexOf(5));
    }

    @Test
    public void testRemoveByObjectFirstAndSecondOccurrence() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(4);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x1 = simpleList.remove(new Integer(4));
        Integer x2 = simpleList.remove(new Integer(4));

        assertEquals(4, x1.intValue());
        assertEquals(4, x2.intValue());
        assertEquals(4, simpleList.size());
        assertEquals(0, simpleList.indexOf(1));
        assertEquals(1, simpleList.indexOf(2));
        assertEquals(2, simpleList.indexOf(3));
        assertEquals(3, simpleList.indexOf(5));
    }

    @Test
    public void testRemoveByObjectNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);

        Integer x = simpleList.remove(null);

        assertNull(x);
        assertEquals(5, simpleList.size());
        assertEquals(0, simpleList.indexOf(1));
        assertEquals(1, simpleList.indexOf(2));
        assertEquals(2, simpleList.indexOf(3));
        assertEquals(3, simpleList.indexOf(4));
        assertEquals(4, simpleList.indexOf(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.set(0, 3);

        assertEquals(1, simpleList.size());
        assertEquals(3, simpleList.get(0).intValue());
    }

    @Test
    public void testSetEnd() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        simpleList.set(2, 4);

        assertEquals(3, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(4, simpleList.get(2).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexToLarge() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);

        simpleList.set(3, 3);
    }

    @Test
    public void testSetMiddle() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        simpleList.set(1, 3);

        assertEquals(3, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(3, simpleList.get(2).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegIndex() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.set(-1, 8);
    }

    @Test
    public void testSetNull() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        simpleList.set(1, null);

        assertEquals(3, simpleList.size());
        assertEquals(1, simpleList.get(0).intValue());
        assertNull(simpleList.get(1));
        assertEquals(3, simpleList.get(2).intValue());
    }

    @Test
    public void testSetStart() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);

        simpleList.set(0, 3);

        assertEquals(3, simpleList.size());
        assertEquals(3, simpleList.get(0).intValue());
        assertEquals(2, simpleList.get(1).intValue());
        assertEquals(3, simpleList.get(2).intValue());
    }

    @Test
    public void testSize() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(10);
        simpleList.add(3);
        simpleList.add(3);
        simpleList.add(2);
        simpleList.add(4);

        assertEquals(simpleList.size(), 5);
    }

    @Test
    public void testSizeEmptyList() {
        ISimpleList<Integer> simpleList = new SimpleLinkedList<>();

        assertEquals(simpleList.size(), 0);
    }

    @Test
    public void testSublist() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.push(0);
        simpleList.push(1);
        simpleList.push(2);
        simpleList.push(3);
        simpleList.push(4);
        simpleList.push(5);

        ISimpleList<Integer> subList = simpleList.subList(1, 4);

        assertEquals(4, subList.size());
        assertEquals(1, subList.getFirst().intValue());
        assertEquals(4, subList.getLast().intValue());
    }

    @Test
    public void testSublistAtEnd() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(3);
        simpleList.add(6);
        simpleList.add(9);

        ISimpleList<Integer> e = simpleList.subList(2, 3);

        assertEquals(4, simpleList.size());
        assertEquals(5, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(6, simpleList.get(2).intValue());
        assertEquals(9, simpleList.get(3).intValue());

        assertEquals(2, e.size());
        assertEquals(6, e.get(0).intValue());
        assertEquals(9, e.get(1).intValue());
    }

    @Test
    public void testSublistEmptyRange() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(3);
        simpleList.add(6);
        simpleList.add(9);

        ISimpleList<Integer> e = simpleList.subList(2, 2);

        assertEquals(4, simpleList.size());
        assertEquals(5, simpleList.get(0).intValue());
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(6, simpleList.get(2).intValue());
        assertEquals(9, simpleList.get(3).intValue());

        assertEquals(1, e.size());
        assertEquals(6, e.get(0).intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSublistFromLargerThenTo() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);

        simpleList.subList(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistFromNeg() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);

        simpleList.subList(-1, 3);
    }

    @Test
    public void testSublistFromStart() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(3);
        simpleList.add(6);
        simpleList.add(9);

        ISimpleList<Integer> e = simpleList.subList(0, 2);

        assertEquals(4, simpleList.size());
        assertEquals(Integer.valueOf(5), simpleList.get(0));
        assertEquals(3, simpleList.get(1).intValue());
        assertEquals(6, simpleList.get(2).intValue());
        assertEquals(9, simpleList.get(3).intValue());

        assertEquals(3, e.size());
        assertEquals(5, e.get(0).intValue());
        assertEquals(3, e.get(1).intValue());
        assertEquals(6, e.get(2).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistToTooLarge() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();

        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);
        simpleList.add(5);

        simpleList.subList(0, 4);
    }
}
