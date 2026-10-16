package e02;

/**
 * Contador compartido SIN protección.
 * Dos hilos pueden leer el mismo valor y pisarse al escribir.
 */
public class Contador {
    private int valor = 0;

    public void incrementar() {
        // No es atómico: leer → sumar → escribir
        int actual = valor;
        valor = actual + 1;
    }

    public int getValor() {
        return valor;
    }
}
