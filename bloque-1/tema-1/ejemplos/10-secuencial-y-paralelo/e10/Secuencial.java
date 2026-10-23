package e10;

/**
 * 1.000 tareas, una detrás de otra, en el hilo main.
 * Cada una tarda 20 ms: el proceso tarda unos 20 segundos.
 * main guarda todos los resultados en su array.
 */
public class Secuencial {

    public static void main(String[] args) throws InterruptedException {
        long[] resultados = new long[Tarea.TOTAL];

        System.out.println("Secuencial. Hilo: " + Thread.currentThread().getName());
        System.out.println(Tarea.TOTAL + " tareas × " + Tarea.DURACION_MS + " ms");
        System.out.println("Esperado: unos " + (Tarea.TOTAL * Tarea.DURACION_MS / 1000) + " s");
        System.out.println("---");

        long inicio = System.nanoTime();

        for (int numero = 1; numero <= Tarea.TOTAL; numero++) {
            resultados[numero - 1] = Tarea.ejecutar(numero);
            if (numero % 100 == 0) {
                System.out.println("[main] guardada la tarea " + numero + " / " + Tarea.TOTAL);
            }
        }
        long ms = (System.nanoTime() - inicio) / 1_000_000;

        informar(resultados, ms);
    }

    static void informar(long[] resultados, long ms) {
        long suma = Tarea.suma(resultados);
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados");
        System.out.println("[main] resultado final = " + suma + " (esperado " + Tarea.sumaEsperada() + ")");
        System.out.println("[main] tiempo = " + ms + " ms");
    }
}
