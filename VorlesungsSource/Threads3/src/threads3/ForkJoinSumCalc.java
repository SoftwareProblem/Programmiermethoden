package threads3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author Carsten Gips
 * nach einer Idee aus Urma, Fusco, Mycroft: "Java 8 in Action", Manning Listing 7.2
 */

// Task muss von `RecursiveTask<V>` ableiten
public class ForkJoinSumCalc extends RecursiveTask<Long> {

    private static long[] numbers; // Array mit Zahlen, für alle gemeinsam

    private final int start; // Individueller Start
    private final int end;   // Individuelles Ende

    public ForkJoinSumCalc(long[] numbers) {
        this(0, numbers.length);
        ForkJoinSumCalc.numbers = numbers;
    }

    private ForkJoinSumCalc(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        // Zahlen erzeugen
        // long[] numbers = LongStream.rangeClosed(1, 10).toArray();
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        // neuen Task erzeugen
        ForkJoinTask<Long> task = new ForkJoinSumCalc(numbers);

        // Aufgabe an ForkJoinPool geben und Bearbeitung starten
        long erg = new ForkJoinPool().invoke(task);

        System.out.println(erg);
    }

    // Diese Methode wird vom ForkJoinPool aufgerufen
    @Override
    protected Long compute() {
        int length = end - start;

        // Sequentielle Berechnung, wenn weniger als 10 Elemente
        // Anzahl hier willkürlich!
        if (length < 10) {
            return computeSequentially();
        }

        Long leftErg, rightErg;

        // Task für die linke Hälfte des Arrays
        ForkJoinSumCalc left = new ForkJoinSumCalc(start, start + length / 2);
        // "Linken" Task mit fork() parallelisieren => ForkJoinPool führt
        // compute() in anderem Thread aus
        left.fork();

        // Task für die rechte Hälfte des Arrays
        ForkJoinSumCalc right = new ForkJoinSumCalc(start + length / 2, end);
        // Direkter rekursiver Aufruf für "rechten" Tasks (Weiterverwendung vom
        // aktuellen Thread)
        rightErg = right.compute();

        // Wenn "rechter" Task fertig, auf Ergbnisse vom "linken" Task warten
        leftErg = left.join();

        // Ergebnisse zusammenführen und fertig
        return leftErg + rightErg;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
