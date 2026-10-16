package e05;

import java.util.concurrent.ThreadLocalRandom;

public class Incrementador implements Runnable {
    private final Contador contador;

    public Incrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        // Espera aleatoria amplia: así el planificador no entra siempre en el mismo orden
        long esperaMs = ThreadLocalRandom.current().nextLong(50, 800);
        System.out.println("[" + yo + "] listo... espera " + esperaMs + " ms antes de pedir el Lock");
        try {
            Thread.sleep(esperaMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        contador.incrementar();
    }
}
