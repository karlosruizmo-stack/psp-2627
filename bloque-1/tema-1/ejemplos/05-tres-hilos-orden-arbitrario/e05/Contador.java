package e05;

/**
 * Contador con Lock (synchronized).
 * Solo un hilo entra a la vez: acquire -> update -> release.
 */
public class Contador {
    private int valor = 0;

    public synchronized void incrementar() {
        String yo = Thread.currentThread().getName();

        // acquire: entrar en synchronized = coger el Lock
        System.out.println("[" + yo + "] acquire");

        int actual = valor;
        valor = actual + 1;
        System.out.println("[" + yo + "] update  contador = " + valor);

        // release: al salir del método synchronized
        System.out.println("[" + yo + "] release");
    }

    public synchronized int getValor() {
        return valor;
    }
}
