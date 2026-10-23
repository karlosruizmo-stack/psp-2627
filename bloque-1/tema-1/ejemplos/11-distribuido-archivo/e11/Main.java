package e11;

import java.io.IOException;

/**
 * Proceso que manda el trabajo.
 * No ejecuta las tareas: escribe la orden en el archivo y espera la respuesta.
 * Cuando llega, main guarda el resultado.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        long[] resultados = new long[Canal.TAREAS];

        System.out.println("[main] canal: " + Canal.ARCHIVO);
        System.out.println("[main] el otro proceso es e11.Trabajador. Si no está arrancado, me quedo esperando.");
        System.out.println("---");
        Canal.escribir("libre");

        for (int numero = 1; numero <= Canal.TAREAS; numero++) {
            String orden = "ejecuta tarea " + numero;

            Canal.escribir(orden);

            System.out.println("[main] digo: " + orden);

            String respuesta = esperar("tarea " + numero + " completa");
            System.out.println("[main] leo: tarea " + numero + " completa");

            long resultado = parseResultado(respuesta);
            resultados[numero - 1] = resultado;

            System.out.println("[main] guardo tarea " + numero + " -> " + resultado);

            System.out.println("[main] espero antes de contestar");
            Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        }

        Canal.escribir("fin");
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("  tarea " + (i + 1) + " -> " + resultados[i]);
        }
    }

    private static String esperar(String prefijo) throws IOException, InterruptedException {
        while (true) {
            String mensaje = Canal.leer();
            if (mensaje.startsWith(prefijo) && mensaje.contains("resultado=")) {
                return mensaje;
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }

    private static long parseResultado(String mensaje) {
        String marca = "resultado=";
        int inicio = mensaje.indexOf(marca);
        String valor = mensaje.substring(inicio + marca.length()).trim();
        int salto = valor.indexOf('\n');
        if (salto >= 0) {
            valor = valor.substring(0, salto).trim();
        }
        return Long.parseLong(valor);
    }
}
