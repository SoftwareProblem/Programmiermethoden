package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV8 {
    private static final int MAX = 20;
    private int count;

    public synchronized void anmelden(StudiV8 s) {
        while (count >= MAX) {  // noch kein Platz frei
            try {
                wait();  // warte "auf" dem Klausur-Objekt
            } catch (InterruptedException exc) {
            }
        }
        count++;  // freier Platz da: melde an
    }

    public synchronized void abmelden(StudiV8 s) {
        count--;
    }
}

public class StudiV8 implements Runnable {
    private static final KlausurV8 k = new KlausurV8();

    public static void main(String[] args) {
        StudiV8 x = new StudiV8();
        StudiV8 y = new StudiV8();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
