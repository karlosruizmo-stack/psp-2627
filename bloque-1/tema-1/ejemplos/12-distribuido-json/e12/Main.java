package e12;

import java.io.IOException;

/**
 * Proceso que manda el trabajo.
 * No ejecuta las tareas: envía la orden en JSON y espera la respuesta.
 * Cuando llega, main guarda el resultado.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        long[] resultados = new long[Canal.TAREAS];

        System.out.println("[main] canal: " + Canal.ARCHIVO);
        System.out.println("[main] el otro proceso es e12.Trabajador. Si no está arrancado, me quedo esperando.");
        System.out.println("---");

        for (int numero = 1; numero <= Canal.TAREAS; numero++) {
            Canal.enviar(Mensaje.ejecuta(numero));
            System.out.println("[main] digo: ejecuta tarea " + numero);

            Mensaje respuesta = esperarCompleta(numero);
            resultados[numero - 1] = respuesta.resultado;
            System.out.println("[main] guardo tarea " + numero + " -> " + respuesta.resultado);

            System.out.println("[main] espero antes de contestar");
            Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        }

        Canal.enviar(Mensaje.fin());
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("  tarea " + (i + 1) + " -> " + resultados[i]);
        }
    }

    private static Mensaje esperarCompleta(int numero) throws IOException, InterruptedException {
        while (true) {
            Mensaje mensaje = Canal.recibir();
            if (mensaje != null && mensaje.esCompleta() && mensaje.tarea == numero) {
                return mensaje;
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }
}
