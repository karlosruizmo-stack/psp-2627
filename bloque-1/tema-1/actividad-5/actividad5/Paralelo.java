package actividad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Paralelo {

    static final int PEDIDOS = 800;
    static final int HILOS = 8;
    static final int POR_HILO = PEDIDOS / HILOS;   // 100
    static final int MS_POR_PEDIDO = 25;


    static class Tramo extends Thread {
        private final int desde;
        private final int hasta;
        private final int[] resultados;

        Tramo(int desde, int hasta) {
            this.desde = desde;
            this.hasta = hasta;
            this.resultados = new int[hasta - desde + 1];
        }

        @Override
        public void run() {
            for (int i = 0; i < resultados.length; i++) {
                try {
                    Thread.sleep(MS_POR_PEDIDO);   // preparar el pedido desde+i
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                resultados[i] = 1;
            }
        }

        int[] getResultados() {
            return resultados;
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        long inicio = System.currentTimeMillis();

        Tramo[] tramos = new Tramo[HILOS];
        for (int h = 0; h < HILOS; h++) {
            int desde = h * POR_HILO + 1;
            int hasta = (h + 1) * POR_HILO;
            tramos[h] = new Tramo(desde, hasta);
            tramos[h].start();
        }

        for (Tramo t : tramos) {
            t.join();
        }


        int[] todos = new int[PEDIDOS];
        for (int h = 0; h < HILOS; h++) {
            System.arraycopy(tramos[h].getResultados(), 0, todos, h * POR_HILO, POR_HILO);
        }

        int total = 0;
        for (int r : todos) {
            total += r;
        }

        long ms = System.currentTimeMillis() - inicio;
        String log = "Paralelo -> total: " + total + " | tiempo: " + ms + " ms";
        System.out.println(log);
        Files.writeString(Path.of("paralelo.log"), log + System.lineSeparator());
    }
}
