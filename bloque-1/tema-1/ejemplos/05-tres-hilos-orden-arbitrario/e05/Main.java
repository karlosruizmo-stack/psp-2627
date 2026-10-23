package e05;

/**
 * Como el ejemplo 03, pero con TRES hilos.
 * El contador siempre acaba en 3 (Lock).
 * El ORDEN de quién hace acquire primero cambia entre ejecuciones.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread h1 = new Thread(new Incrementador(contador), "Hilo 1");
        Thread h2 = new Thread(new Incrementador(contador), "Hilo 2");
        Thread h3 = new Thread(new Incrementador(contador), "Hilo 3");

        System.out.println("main: start() de Hilo 1, 2 y 3");
        System.out.println("Esperado: contador = 3 (orden de acquire: arbitrario)");
        System.out.println("---");

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

        System.out.println("---");
        System.out.println("main: join() terminado. contador = " + contador.getValor());
        System.out.println("Ejecutad varias veces: el orden Hilo X / Y / Z cambia.");
    }
}
