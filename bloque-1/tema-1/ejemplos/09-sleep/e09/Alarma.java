package e09;

/**
 * Duerme un rato con Thread.sleep y se despierta sola.
 * Nadie tiene que hacer notify().
 */
public class Alarma implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Alarma(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run() {
        try {
            System.out.println("[" + nombre + "] me duermo " + milisegundos + " ms...");
            Thread.sleep(milisegundos);
            System.out.println("[" + nombre + "] ¡desperté sola! (nadie hizo notify)");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras dormía");
        }
    }
}
