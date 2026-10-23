package e12;

import java.io.IOException;

/**
 * Otro proceso. No comparte memoria con main.
 * Espera una orden JSON, avisa de que está trabajando y deja el resultado en JSON.
 */
public class Trabajador {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("[trabajador] espero órdenes en " + Canal.ARCHIVO);

        while (true) {
            Mensaje mensaje = Canal.recibir();

            if (mensaje != null && mensaje.esFin()) {
                System.out.println("[trabajador] leo: fin. cierro.");
                return;
            }

            if (mensaje != null && mensaje.esEjecuta()) {
                int numero = mensaje.tarea;

                System.out.println("[trabajador] leo: ejecuta tarea " + numero);
                System.out.println("[trabajador] estoy trabajando");

                Canal.enviar(Mensaje.trabajando(numero));
                long resultado = ejecutar(numero);
                Canal.enviar(Mensaje.completa(numero, resultado));

                System.out.println("[trabajador] digo: tarea " + numero + " completa, resultado=" + resultado);
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }

    private static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        return (long) numero * numero;
    }
}
