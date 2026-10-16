package e09;

/**
 * sleep: el hilo se para un rato y sigue solo.
 * No es wait: no hace falta notify para despertar.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread corta = new Thread(new Alarma("alarma-corta", 500), "alarma-corta");
        Thread media = new Thread(new Alarma("alarma-media", 1000), "alarma-media");
        Thread larga = new Thread(new Alarma("alarma-larga", 1500), "alarma-larga");

        System.out.println("sleep: tres alarmas se duermen; cada una se despierta sola");
        System.out.println("---");
        corta.start();
        media.start();
        larga.start();

        System.out.println("[main] mientras ellas duermen, yo sigo (no estoy bloqueado)");

        corta.join();
        media.join();
        larga.join();
        System.out.println("---");
        System.out.println("main: fin");
    }
}
