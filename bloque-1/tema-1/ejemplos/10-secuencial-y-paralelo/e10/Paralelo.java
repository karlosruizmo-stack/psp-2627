package e10;

/**
 * El mismo trabajo que Secuencial: 1.000 tareas de 20 ms.
 * Aquí hay 10 hilos y cada uno hace 100.
 * main espera con join y entonces guarda todos los resultados.
 */
public class Paralelo {

    public static void main(String[] args) throws InterruptedException {
        if (Tarea.TOTAL != Tarea.HILOS * Tarea.POR_HILO) {
            throw new IllegalStateException("TOTAL tiene que repartirse exacto entre los hilos");
        }

        long[] resultados = new long[Tarea.TOTAL];
        Trozo[] trozos = new Trozo[Tarea.HILOS];
        Thread[] hilos = new Thread[Tarea.HILOS];

        System.out.println("Paralelo. Hilo: " + Thread.currentThread().getName());
        System.out.println(Tarea.HILOS + " hilos × " + Tarea.POR_HILO + " tareas × " + Tarea.DURACION_MS + " ms");
        System.out.println("Esperado: unos " + (Tarea.POR_HILO * Tarea.DURACION_MS / 1000) + " s, si van a la vez");
        System.out.println("---");

        long inicio = System.nanoTime();
        for (int h = 0; h < Tarea.HILOS; h++) {
            int desde = h * Tarea.POR_HILO + 1;
            int hasta = desde + Tarea.POR_HILO - 1;
            trozos[h] = new Trozo(h + 1, desde, hasta);
            hilos[h] = new Thread(trozos[h], "hilo-" + (h + 1));
            hilos[h].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        for (Trozo trozo : trozos) {
            guardar(resultados, trozo);
        }
        long ms = (System.nanoTime() - inicio) / 1_000_000;

        Secuencial.informar(resultados, ms);
    }

    /** main es quien escribe en el array de resultados. */
    private static void guardar(long[] resultados, Trozo trozo) {
        for (int i = 0; i < trozo.parcial.length; i++) {
            resultados[trozo.desde - 1 + i] = trozo.parcial[i];
        }
        System.out.println("[main] guardo el tramo " + trozo.desde + ".." + trozo.hasta);
    }
}
