package e02;

/**
 * Problema: dos hilos incrementan el MISMO contador sin Lock.
 * Esperado: 200_000. Real: casi siempre menos (condiciones de carrera).
 */
public class Main {

    private static final int INCREMENTOS_POR_HILO = 100_000;

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread a = new Thread(new Incrementador(contador, INCREMENTOS_POR_HILO), "hilo-A");
        Thread b = new Thread(new Incrementador(contador, INCREMENTOS_POR_HILO), "hilo-B");

        System.out.println("Dos hilos × " + INCREMENTOS_POR_HILO + " = esperado "
                + (2 * INCREMENTOS_POR_HILO));
        System.out.println("Sin Lock. Arrancamos...");

        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Resultado real: " + contador.getValor());
        System.out.println("(Si es menor que el esperado: se han pisado lecturas/escrituras)");
    }
}
