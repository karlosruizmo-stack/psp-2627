package e08;

/** Coge B y luego pide A. */
public class HiloDos implements Runnable {

    @Override
    public void run() {
        synchronized (Locks.B) {
            System.out.println("[Hilo 2] acquire LOCK_B");
            dormir(100);
            System.out.println("[Hilo 2] intenta acquire LOCK_A...");
            synchronized (Locks.A) {
                System.out.println("[Hilo 2] tiene B y A"); // no llega
            }
        }
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
