package methodreferences;

import java.util.*;

/**
 * @author Carsten Gips
 */

public class StudiListMethodreference implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public static int cmpName(Studi o1, Studi o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public static void main(String[] args) {
        StudiListMethodreference sl = new StudiListMethodreference();
        sl.add(new Studi("Klaas", 2));
        sl.add(new Studi("Hein", 10));
        sl.add(new Studi("Pit", 42));

        // 1. Referenz auf statische Methode
        Collections.sort(sl.list, StudiListMethodreference::cmpName);
        Collections.sort(sl.list, (o1, o2) -> StudiListMethodreference.cmpName(o1, o2));

        // 2. Referenz auf Instanz-Methode eines bestimmten Objekts
        Collections.sort(sl.list, sl::cmpCredits);
        Collections.sort(sl.list, (o1, o2) -> sl.cmpCredits(o1, o2));

        // 3. Referenz auf Instanz-Methode eines bestimmten Typs
        Collections.sort(sl.list, Studi::compareCredits);
        Collections.sort(sl.list, (o1, o2) -> o1.compareCredits(o2));

        // dito, verpackt in Methoden ...
        sl.sortName();
        sl.sortCredits();
        sl.sortCreditsStudi();

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

    public int cmpCredits(Studi o1, Studi o2) {
        return o1.getCredits() - o2.getCredits();
    }

    public void sortName() {
        // 1. Referenz auf statische Methode
        Collections.sort(list, StudiListMethodreference::cmpName);
    }

    public void sortCredits() {
        // 2. Referenz auf Instanz-Methode eines bestimmten Objekts
        Collections.sort(list, this::cmpCredits);
    }

    public void sortCreditsStudi() {
        // 3. Referenz auf Instanz-Methode eines bestimmten Typs
        Collections.sort(list, Studi::compareCredits);
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
