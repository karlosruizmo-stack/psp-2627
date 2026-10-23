package e08;

/**
 * Deadlock: cada hilo coge un Lock y espera el del otro.
 * El programa se queda colgado: nadie hace release.
 *
 * Para salir en clase: Stop del Run en IntelliJ (o Ctrl+C).
 */
public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new HiloUno(), "Hilo 1");
        Thread t2 = new Thread(new HiloDos(), "Hilo 2");

        System.out.println("Deadlock a la vista: Hilo 1 coge A y pide B; Hilo 2 coge B y pide A");
        System.out.println("---");
        t1.start();
        t2.start();
        // No hacemos join: si lo hicierais, main también se quedaría esperando para siempre
        System.out.println("main: los hilos ya están en deadlock (Stop para cortar)");
    }
}
