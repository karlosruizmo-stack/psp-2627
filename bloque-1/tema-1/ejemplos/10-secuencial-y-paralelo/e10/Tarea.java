package e10;

/**
 * Una tarea simulada: espera 20 ms y suma 1.
 * 1.000 tareas, así que el resultado final es 1000.
 * Secuencial y Paralelo llaman a este mismo método.
 */
public final class Tarea {

    public static final int TOTAL = 1_000;
    public static final int HILOS = 10;
    public static final int POR_HILO = TOTAL / HILOS;
    public static final long DURACION_MS = 20;

    private Tarea() {
    }

    /** numero solo identifica la tarea. El trabajo es sumar 1. */
    public static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(DURACION_MS);
        return 1;
    }

    public static long suma(long[] resultados) {
        long total = 0;
        for (long resultado : resultados) {
            total += resultado;
        }
        return total;
    }

    /** Una unidad por tarea. Si falta alguna, el total no llega a 1000. */
    public static long sumaEsperada() {
        return TOTAL;
    }
}
