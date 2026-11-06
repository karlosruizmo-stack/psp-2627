package consync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Aforo aforo = new Aforo();
        Thread[] hilos = new Thread[4];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Visitante(aforo, 1000), "Visitante-" + (i + 1));
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        System.out.println("Esperado: 4000");
        System.out.println("Total obtenido: " + aforo.getTotal());
    }
}
