package e10;

/**
 * Un hilo se queda un tramo de 100 tareas.
 * El array parcial es suyo. main lo copia cuando este hilo ha terminado.
 */
public class Trozo implements Runnable {

    final int id;
    final int desde;
    final int hasta;
    final long[] parcial;

    public Trozo(int id, int desde, int hasta) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.parcial = new long[hasta - desde + 1];
    }

    @Override
    public void run() {
        try {
            System.out.println("[hilo-" + id + "] empiezo tareas " + desde + ".." + hasta);
            for (int numero = desde; numero <= hasta; numero++) {
                parcial[numero - desde] = Tarea.ejecutar(numero);
            }
            System.out.println("[hilo-" + id + "] tramo listo");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[hilo-" + id + "] me interrumpieron");
        }
    }
}
