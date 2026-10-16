package e07;

/**
 * Un cocinero. Puede avisar con notify() o con notifyAll().
 */
public class Cocinero implements Runnable {
    private final Comida comida;
    private final boolean aTodos;

    public Cocinero(Comida comida, boolean aTodos) {
        this.comida = comida;
        this.aTodos = aTodos;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(250); // cocina un poco
            if (aTodos) {
                comida.avisarConNotifyAll();
            } else {
                comida.avisarConNotify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
