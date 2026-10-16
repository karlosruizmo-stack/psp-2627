package e06;

/**
 * Un plato compartido: o hay comida, o está vacío.
 * El bebé espera (wait) si no hay nada.
 * El cocinero avisa (notify) cuando deja la comida lista.
 */
public class Plato {
    private String comida;
    private boolean listo = false;

    public synchronized void servir(String plato) throws InterruptedException {
        while (listo) {
            System.out.println("[cocinero] el plato aún está lleno → wait()");
            wait();
        }
        comida = plato;
        listo = true;
        System.out.println("[cocinero] sirve \"" + plato + "\" → notify()");
        notify(); // despierta a UN hilo que espera (el bebé)
    }

    public synchronized String comer() throws InterruptedException {
        while (!listo) {
            System.out.println("[bebé] no hay comida → wait()");
            wait();
        }
        String plato = comida;
        listo = false;
        System.out.println("[bebé] come \"" + plato + "\" → notify()");
        notify(); // avisa al cocinero: plato vacío, puede servir otra
        return plato;
    }
}
