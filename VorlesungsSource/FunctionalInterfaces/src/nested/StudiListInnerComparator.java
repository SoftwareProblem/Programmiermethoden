package nested;

import java.util.*;

/**
 * @author Carsten Gips
 */

public class StudiListInnerComparator implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public static void main(String[] args) {
        StudiListInnerComparator si = new StudiListInnerComparator();
        si.add(new Studi("Klaas", 2));
        si.add(new Studi("Hein", 10));
        si.add(new Studi("Pit", 42));

        si.sortName();

        for (Studi s : si) {
            System.out.println(s);
        }
    }

    public void add(Studi s) {
        list.add(s);
    }

    @Override
    public Iterator<Studi> iterator() {
        return new StudiIterator();
    }

    public void sortName() {
        // Vergleich mit Hilfe der inneren Klasse
        Comparator<Studi> c = new StudiNameComparator();
        Collections.sort(list, c);
    }

    // Ausserhalb von StudiListInnerComparator nutzlos => Realisierung als
    // innere Klasse
    private class StudiNameComparator implements Comparator<Studi> {

        @Override
        public int compare(Studi o1, Studi o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }

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
