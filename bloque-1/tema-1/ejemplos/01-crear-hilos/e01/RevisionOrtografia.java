package e01;

/**
 * Opción B: implementar Runnable.
 * Lo habitual: la clase aún puede heredar de otra si hace falta.
 */
public class RevisionOrtografia implements Runnable {

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + yo + "] revisando palabra " + i);
            pausa(500);
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
