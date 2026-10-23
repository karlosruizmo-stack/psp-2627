package e07;

/**
 * Varios bebés esperan. Un cocinero avisa.
 * Compara notify() (uno) vs notifyAll() (todos).
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1) Tres bebés + cocinero con notify() ===");
        demoNotify();

        Thread.sleep(300);
        System.out.println();
        System.out.println("=== 2) Tres bebés + cocinero con notifyAll() ===");
        demoNotifyAll();
    }

    private static void demoNotify() throws InterruptedException {
        Comida comida = new Comida();
        Thread[] bebes = arrancarBebes(comida, 3);
        Thread cocinero = new Thread(new Cocinero(comida, false), "cocinero");
        cocinero.start();

        Thread.sleep(400);
        System.out.println(">> Tras notify(): despertados = " + comida.getDespertados() + " (esperado: 1)");

        comida.liberarRestantes();
        joinAll(bebes);
        cocinero.join();
        System.out.println(">> Al final (tras limpieza): despertados = " + comida.getDespertados());
    }

    private static void demoNotifyAll() throws InterruptedException {
        Comida comida = new Comida();
        Thread[] bebes = arrancarBebes(comida, 3);
        Thread cocinero = new Thread(new Cocinero(comida, true), "cocinero");
        cocinero.start();

        joinAll(bebes);
        cocinero.join();
        System.out.println(">> Tras notifyAll(): despertados = " + comida.getDespertados() + " (esperado: 3)");
    }

    private static Thread[] arrancarBebes(Comida comida, int n) {
        Thread[] bebes = new Thread[n];
        for (int i = 0; i < n; i++) {
            String nombre = "bebé " + (i + 1);
            bebes[i] = new Thread(new Bebe(comida, nombre), nombre);
            bebes[i].start();
        }
        return bebes;
    }

    private static void joinAll(Thread[] hilos) throws InterruptedException {
        for (Thread h : hilos) {
            h.join();
        }
    }
}
