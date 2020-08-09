package nested;

import java.util.*;

/**
 * @author Carsten Gips
 */

public class StudiListAnonymComparator implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public static void main(String[] args) {
        StudiListAnonymComparator si = new StudiListAnonymComparator();
        si.add(new Studi("Klaas", 2));
        si.add(new Studi("Hein", 10));
        si.add(new Studi("Pit", 42));

        si.sortName();
        si.sortCredits();

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
        // Anonyme Klasse zum Vergleichen der Namen, hier mit Hilfsvariable
        Comparator<Studi> c = new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list, c);
    }

    public void sortCredits() {
        // Anonyme Klasse zum Vergleichen der Credits, hier ohne Hilfsvariable
        Collections.sort(list, new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });
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
