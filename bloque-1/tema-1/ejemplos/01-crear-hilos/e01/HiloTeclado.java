package e01;

/**
 * Opción A: heredar de Thread.
 * Simple, pero la clase ya no puede heredar de otra.
 */
public class HiloTeclado extends Thread {

    public HiloTeclado(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + getName() + "] tecla " + i);
            pausa(400);
        }
        System.out.println("[" + getName() + "] fin");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
