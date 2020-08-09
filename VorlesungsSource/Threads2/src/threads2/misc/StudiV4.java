package threads2.misc;

/**
 * @author Carsten Gips
 */

class KlausurV4 {
    private int count;

    public void anmelden(StudiV4 s) {
        count++;
    }

    public void abmelden(StudiV4 s) {
        count--;
    }
}

public class StudiV4 implements Runnable {
    private static final KlausurV4 k = new KlausurV4();

    public static void main(String[] args) {
        StudiV4 x = new StudiV4();
        StudiV4 y = new StudiV4();

        new Thread(x).start();
        new Thread(y).start();
    }

    @Override
    public void run() {
        k.anmelden(this);
    }

}
