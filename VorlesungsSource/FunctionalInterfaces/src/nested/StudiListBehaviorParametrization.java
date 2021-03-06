package nested;

import java.util.*;

/**
 * @author Carsten Gips
 */

public class StudiListBehaviorParametrization implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public static void main(String[] args) {
        StudiListBehaviorParametrization sl = new StudiListBehaviorParametrization();
        sl.add(new Studi("Klaas", 2));
        sl.add(new Studi("Hein", 10));
        sl.add(new Studi("Pit", 42));

        // sortName
        sl.sort(new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Studi s : sl) {
            System.out.println(s);
        }

        // sortCredits
        sl.sort(new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });

        for (Studi s : sl) {
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

    public void sort(Comparator<Studi> c) {
        Collections.sort(list, c);
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
