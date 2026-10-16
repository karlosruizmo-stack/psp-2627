package e02;

public class Incrementador implements Runnable {
    private final Contador contador;
    private final int veces;

    public Incrementador(Contador contador, int veces) {
        this.contador = contador;
        this.veces = veces;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            contador.incrementar();
        }
    }
}
