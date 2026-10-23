package e11;

import java.io.IOException;

/**
 * Otro proceso. No comparte memoria con main.
 * Espera una orden en el archivo, hace la tarea y deja el resultado escrito.
 */
public class Trabajador {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("[trabajador] espero órdenes en " + Canal.ARCHIVO);

        while (true) {
            String mensaje = Canal.leer();
            if (mensaje.equals("fin")) {
                System.out.println("[trabajador] leo: fin. cierro.");
                return;
            }
            if (mensaje.startsWith("ejecuta tarea ")) {
                int numero = Integer.parseInt(mensaje.substring("ejecuta tarea ".length()).trim());
                System.out.println("[trabajador] leo: " + mensaje);
                System.out.println("[trabajador] estoy trabajando");


                Canal.escribir("estoy trabajando");
                long resultado = ejecutar(numero);

                Canal.escribir("tarea " + numero + " completa" + System.lineSeparator()
                        + "resultado=" + resultado);
                System.out.println("[trabajador] digo: tarea " + numero + " completa");
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }

    private static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        return (long) numero * numero;
    }
}
