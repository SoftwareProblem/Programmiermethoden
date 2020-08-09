package methodreferences;

/**
 * @author Carsten Gips
 */

public class Wuppie {
    public static void wuppie() {
        System.out.println("wuppie");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("wuppie");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("wuppie"));

        Thread t3 = new Thread(Wuppie::wuppie);

        t1.start();
        t2.start();
        t3.start();
    }

}
