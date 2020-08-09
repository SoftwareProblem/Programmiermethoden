package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV6 {
    private int count;

    public synchronized void anmelden(StudiV6 s) {
        count++;
    }

    public synchronized void abmelden(StudiV6 s) {
        count--;
    }
}

public class StudiV6 implements Runnable {
    private static final KlausurV6 k = new KlausurV6();

    public static void main(String[] args) {
        StudiV6 x = new StudiV6();
        StudiV6 y = new StudiV6();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
