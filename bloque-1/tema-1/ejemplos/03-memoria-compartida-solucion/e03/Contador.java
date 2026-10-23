package e03;

/**
 * Contador compartido CON exclusión mutua.
 * Solo un hilo entra a la vez en incrementar().
 */
public class Contador {
    private int valor = 0;

    public synchronized void incrementar() {
        int actual = valor;
        valor = actual + 1;
    }

    public synchronized int getValor() {
        return valor;
    }
}
