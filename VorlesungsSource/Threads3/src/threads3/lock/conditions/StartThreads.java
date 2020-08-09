package threads3.lock.conditions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carsten Gips
 */

class Display extends Thread {
    private final Lock lock;
    private final Condition condition;

    public Display(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();

        System.out.println("Display-Thread: warte auf Berechnungsergebnis");

        try {
            // Auf Daten vom Calulator-Thread warten
            // Vorteil Lock-Objekt/Condition: Timeout möglich!
            // (false: Zeit vor Benachrichtigung abgelaufen => Zeit variieren)
            if (condition.await(4000, TimeUnit.MILLISECONDS)) {
                // Daten "darstellen"
                System.out.println("Display-Thread: Ergebnis ist endlich da :-)");
            } else {
                // Wartezeit abgelaufen, keine Daten
                System.out.println("Display-Thread: zu lange gewartet, kein Ergebnis :(");
            }
        } catch (InterruptedException e) {
            return; // Abbruch: Hier ging was schief!
        } finally {
            lock.unlock(); // Nachteil Lock-Objekt: Selbst um Un-Locking kümmern
        }
    }

}

class Calculator extends Thread {
    private final Lock lock;
    private final Condition condition;

    public Calculator(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();

        System.out.println("Calculator-Thread: starte Berechung");

        try {
            Thread.sleep(2000); // lange Berechnung ;-)

            System.out.println("Calculator-Thread: Berechnung beendet");

            // Display-Thread benachrichtigen
            condition.signal();
        } catch (InterruptedException e) {
            return; // Abbruch: Hier ging was schief!
        } finally {
            lock.unlock(); // Nachteil Lock-Objekt: Selbst um Un-Locking kümmern
        }
    }
}

public class StartThreads {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(); // gemeinsames Monitor-Objekt
        Condition condition = lock.newCondition();

        Display displayThread = new Display(lock, condition);
        Calculator calculatorThread = new Calculator(lock, condition);

        displayThread.start();
        // DisplayThread muss nicht unbedingt vor CalculatorThread starten
        // (kein Deadlock mehr durch Timeout im `await` => Starts vertauschen)
        // Thread.sleep(10);
        calculatorThread.start();
    }
}
