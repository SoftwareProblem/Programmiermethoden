package nested;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Carsten Gips
 */

public class StudiListNested implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public static void main(String[] args) {
        StudiListNested si = new StudiListNested();
        si.add(new Studi("Klaas", 2));
        si.add(new Studi("Hein", 10));
        si.add(new Studi("Pit", 42));

        for (Studi s : si) {
            System.out.println(s);
        }
    }

    public void add(Studi s) {
        list.add(s);
    }

    @Override
    public Iterator<Studi> iterator() {
        // Nutzung der inneren Klasse zur Iteration
        return new StudiIterator();
    }

    // Innere Klasse: Zugriff auf privates Feld `List<Studi> list` von
    // StudiListNested
    private class StudiIterator implements Iterator<Studi> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public Studi next() {
            try {
                return list.get(cursor++);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
