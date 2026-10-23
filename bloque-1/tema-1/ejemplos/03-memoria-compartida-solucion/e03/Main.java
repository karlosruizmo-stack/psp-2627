package e03;

/**
 * Solución: el mismo escenario que el ejemplo 02, pero con synchronized.
 * Esperado = real = 200_000.
 */
public class Main {

    private static final int INCREMENTOS_POR_HILO = 100_000;

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread a = new Thread(new Incrementador(contador, INCREMENTOS_POR_HILO), "hilo-A");
        Thread b = new Thread(new Incrementador(contador, INCREMENTOS_POR_HILO), "hilo-B");

        System.out.println("Dos hilos × " + INCREMENTOS_POR_HILO + " = esperado "
                + (2 * INCREMENTOS_POR_HILO));
        System.out.println("Con synchronized. Arrancamos...");

        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Resultado real: " + contador.getValor());
        System.out.println("(Debe coincidir siempre con el esperado)");
    }
}
