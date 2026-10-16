package e08;

/** Coge A y luego pide B. */
public class HiloUno implements Runnable {

    @Override
    public void run() {
        synchronized (Locks.A) {
            System.out.println("[Hilo 1] acquire LOCK_A");
            dormir(100);
            System.out.println("[Hilo 1] intenta acquire LOCK_B...");
            synchronized (Locks.B) {
                System.out.println("[Hilo 1] tiene A y B"); // no llega
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
