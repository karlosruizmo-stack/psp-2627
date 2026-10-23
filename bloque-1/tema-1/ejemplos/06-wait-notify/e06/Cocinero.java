package e06;

public class Cocinero implements Runnable {
    private final Plato plato;
    private final String[] menu;

    public Cocinero(Plato plato, String[] menu) {
        this.plato = plato;
        this.menu = menu;
    }

    @Override
    public void run() {
        try {
            for (String comida : menu) {
                Thread.sleep(300); // tarda un poco en cocinar
                plato.servir(comida);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
