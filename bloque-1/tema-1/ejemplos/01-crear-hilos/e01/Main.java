package e01;

/**
 * Diapo 17 en código: el hilo main crea los demás con start().
 *
 * - HiloTeclado ........ hereda Thread
 * - RevisionOrtografia . implementa Runnable
 * - Autoguardado ....... implementa Runnable
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Arranca el proceso. Hilo actual: " + Thread.currentThread().getName());
        System.out.println("--- main crea tres hilos ---");

        // Opción A: la clase YA ES un Thread
        Thread teclado = new HiloTeclado("teclado-ui");

        // Opción B: envolvemos el Runnable en un Thread y le damos nombre
        Thread ortografia = new Thread(new RevisionOrtografia(), "ortografia");
        Thread autoguardado = new Thread(new Autoguardado(), "autoguardado");

        // start() pone el hilo en marcha (NO llamar a run() a mano)
        teclado.start();
        ortografia.start();
        autoguardado.start();

        System.out.println("[main] hilos lanzados; espero a que acaben (join)...");

        // main espera: así es el último en morir
        teclado.join();
        ortografia.join();
        autoguardado.join();

        System.out.println("--- todos los hilos han terminado ---");
        System.out.println("[main] fin. Hilo actual: " + Thread.currentThread().getName());
    }
}
