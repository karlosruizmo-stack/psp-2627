package e01;

/** Otro Runnable: misma opción B, otra tarea. */
public class Autoguardado implements Runnable {

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + yo + "] guardando documento (" + i + ")");
            pausa(700);
        }
        System.out.println("[" + yo + "] fin");
    }

    private static void pausa(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
