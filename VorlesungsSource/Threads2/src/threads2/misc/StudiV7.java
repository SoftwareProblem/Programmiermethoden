package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV7 {
    private static final int MAX = 20;
    private int count;

    public synchronized void anmelden(StudiV7 s) {
        if (count < MAX) {
            count++;
        }
    }

    public synchronized void abmelden(StudiV7 s) {
        count--;
    }
}

public class StudiV7 implements Runnable {
    private static final KlausurV7 k = new KlausurV7();

    public static void main(String[] args) {
        StudiV7 x = new StudiV7();
        StudiV7 y = new StudiV7();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
