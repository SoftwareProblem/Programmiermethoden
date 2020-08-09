package threads2.waitnotify;

/**
 * @author Carsten Gips
 */

class Stab {
    boolean inBesitz = false;

    public synchronized void nimm() {
        // geschützt: hier kommt nur einer gleichzeitig rein
        System.out.println("Stab haben will " + Thread.currentThread().getName());
        while (inBesitz) { // Stab schon bei jemanden in Besitz?
            try {
                wait(); // Falls ja: Dann warte "auf" dem Stab
            } catch (InterruptedException exc) {
            }
        }
        inBesitz = true; // Stab war frei; jetzt ist er meins
        System.out.println("Stab hab! " + Thread.currentThread().getName());
    }

    public synchronized void abgeben() {
        // geschützt: hier kommt nur einer gleichzeitig rein
        inBesitz = false; // Stab abgeben
        notifyAll(); // Alle aufwecken: Mir doch egal, wer weiter macht :)
        System.out.println("Stab abgegeben " + Thread.currentThread().getName());
    }
}

public class Staffel extends Thread {
    static private final Stab stab = new Stab();  // gemeinsames Wächterobjekt

    public static void main(String[] args) {
        new Staffel().start();
        new Staffel().start();
        new Staffel().start();
    }

    @Override
    public void run() {
        while (true) {
            takeShortNap();
            stab.nimm();
            laufen();
            stab.abgeben();
        }
    }

    void laufen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("laufe ... " + Thread.currentThread().getName());
            takeShortNap();
        }
    }

    private void takeShortNap() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }
}
