package threads2.waitnotify;

/**
 * @author Carsten Gips
 */

public class StaffelKaputt extends Thread {
    static private final Object stab = new Object();  // gemeinsames Wächterobjekt

    public static void main(String[] args) {
        new StaffelKaputt().start();
        new StaffelKaputt().start();
        new StaffelKaputt().start();
    }

    @Override
    public void run() {
        while (true) {
            nimmStab();
            laufen();
            stabAbgeben();
        }
    }

    private void stabAbgeben() {
        synchronized (stab) {
            stab.notifyAll();
            System.out.println("Stab abgegeben " + Thread.currentThread().getName());
        }
    }

    private void nimmStab() {
        synchronized (stab) {
            System.out.println("Stab haben will " + Thread.currentThread().getName());
            try {
                stab.wait();
            } catch (Exception e) {
            }
            System.out.println("Stab hab! " + Thread.currentThread().getName());
        }
    }

    void laufen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("laufe ... " + Thread.currentThread().getName());
        }
    }
}
