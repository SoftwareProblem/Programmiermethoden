package threads3.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Carsten Gips
 */

public class MyThread implements Runnable {
    int val = 0;

    public static void main(String[] args) {
        MyThread x = new MyThread();

        /*
         * Auszug aus der Javadoc zu `Executors#newCachedThreadPool()`:
         *
         * Creates a thread pool that creates new threads as needed, but will reuse
         * previously constructed threads when they are available. These pools will
         * typically improve the performance of programs that execute many short-lived
         * asynchronous tasks. Calls to execute will reuse previously constructed
         * threads if available. If no existing thread is available, a new thread will
         * be created and added to the pool. Threads that have not been used for sixty
         * seconds are terminated and removed from the cache. Thus, a pool that remains
         * idle for long enough will not consume any resources. Note that pools with
         * similar properties but different details (for example, timeout parameters)
         * may be created using ThreadPoolExecutor constructors.
         *
         */
        ExecutorService pool = Executors.newCachedThreadPool();

        /*
         * Achtung: Runnable-Objekt wird wiederverwendet und wird auf 2 bis 3 Threads
         * parallel ausgeführt. Dabei können diese sich gegenseitig ablösen! Achten Sie
         * auf die Ausgabe ("pool-1-thread-3") ...
         *
         * Wenn das stört, muss entsprechend synchronisiert werden.
         *
         * Da `Thread` das Interface `Runnable` implementiert, können auch "echte"
         * Threads über den Executor mehrfach gestartet werden.
         *
         */
        pool.execute(x); // x.start()
        pool.execute(x); // x.start()
        pool.execute(x); // x.start()

        // Feierabend :)
        pool.shutdown();
    }

    public synchronized int incrVal() {
        return val++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run(): " + incrVal() + " (" + Thread.currentThread().getName() + ")");
        }
    }
}
