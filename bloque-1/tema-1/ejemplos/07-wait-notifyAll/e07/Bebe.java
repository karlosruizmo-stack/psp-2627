package e07;

public class Bebe implements Runnable {
    private final Comida comida;
    private final String nombre;

    public Bebe(Comida comida, String nombre) {
        this.comida = comida;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            comida.esperar(nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
