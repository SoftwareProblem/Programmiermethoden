package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV9 {
    private static final int MAX = 20;
    private int count;

    public synchronized void anmelden(StudiV9 s) {
        while (count >= MAX) {  // noch kein Platz frei
            try {
                wait();  // warte "auf" dem Klausur-Objekt
            } catch (InterruptedException exc) {
            }
        }
        count++;  // freier Platz da: melde an
    }

    public synchronized void abmelden(StudiV9 s) {
        count--;
        notifyAll();  // alle aufwecken: freier Platz da
    }
}

public class StudiV9 implements Runnable {
    private static final KlausurV9 k = new KlausurV9();

    public static void main(String[] args) {
        StudiV9 x = new StudiV9();
        StudiV9 y = new StudiV9();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
