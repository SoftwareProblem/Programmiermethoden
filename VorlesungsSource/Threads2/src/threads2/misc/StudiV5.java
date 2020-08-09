package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV5 {
    private final Object waechter = new Object(); // gemeinsames Sperr-Objekt
    private int count;

    public void anmelden(StudiV5 s) {
        synchronized (waechter) {
            count++;
        }
    }

    public void abmelden(StudiV5 s) {
        synchronized (waechter) {
            count--;
        }
    }
}

public class StudiV5 implements Runnable {
    private static final KlausurV5 k = new KlausurV5();

    public static void main(String[] args) {
        StudiV5 x = new StudiV5();
        StudiV5 y = new StudiV5();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
