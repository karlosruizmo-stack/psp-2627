package actividad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secuencial {

    static final int PEDIDOS = 800;
    static final int MS_POR_PEDIDO = 25;

    public static void main(String[] args) throws InterruptedException, IOException {
        long inicio = System.currentTimeMillis();

        int[] resultados = new int[PEDIDOS];
        for (int i = 0; i < PEDIDOS; i++) {
            Thread.sleep(MS_POR_PEDIDO);
            resultados[i] = 1;
        }

        int total = 0;
        for (int r : resultados) {
            total += r;
        }

        long ms = System.currentTimeMillis() - inicio;
        String log = "Secuencial -> total: " + total + " | tiempo: " + ms + " ms";
        System.out.println(log);
        Files.writeString(Path.of("secuencial.log"), log + System.lineSeparator());
    }
}