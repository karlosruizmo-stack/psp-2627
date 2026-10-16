package e06;

public class Bebe implements Runnable {
    private final Plato plato;
    private final int raciones;

    public Bebe(Plato plato, int raciones) {
        this.plato = plato;
        this.raciones = raciones;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= raciones; i++) {
                plato.comer();
                Thread.sleep(200); // come despacio
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
