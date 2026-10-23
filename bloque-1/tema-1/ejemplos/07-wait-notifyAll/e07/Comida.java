package e07;

/**
 * Varios bebés esperan a que la comida esté lista.
 * notify() despierta solo a UNO.
 * notifyAll() despierta a TODOS.
 */
public class Comida {
    private boolean lista = false;
    private int despertados = 0;

    public synchronized void esperar(String bebe) throws InterruptedException {
        while (!lista) {
            System.out.println("[" + bebe + "] no hay comida → wait()");
            wait();
        }
        despertados++;
        System.out.println("[" + bebe + "] ¡a comer! (despertados: " + despertados + ")");
    }

    /** El cocinero avisa a UN bebé. */
    public synchronized void avisarConNotify() {
        lista = true;
        System.out.println("[cocinero] ¡comida lista! → notify() (solo UNO debería despertar)");
        notify();
    }

    /** El cocinero avisa a TODOS los bebés. */
    public synchronized void avisarConNotifyAll() {
        lista = true;
        System.out.println("[cocinero] ¡comida lista! → notifyAll() (TODOS deberían despertar)");
        notifyAll();
    }

    public synchronized int getDespertados() {
        return despertados;
    }

    /** Limpieza tras el demo de notify(): los demás bebés no se quedan colgados. */
    public synchronized void liberarRestantes() {
        lista = true;
        System.out.println("[cocinero] notifyAll() de limpieza (despertar a los que siguen esperando)");
        notifyAll();
    }
}
