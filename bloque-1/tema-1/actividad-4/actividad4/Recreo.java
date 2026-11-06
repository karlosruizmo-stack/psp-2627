package actividad4;

public class Recreo {

    private boolean sonando = false;
    private int alumnosQueSalen = 0;

    public synchronized void esperarTimbre(String alumno) {
        System.out.println(alumno + " esta esperando el timbre...");
        while (!sonando) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        alumnosQueSalen++;
        System.out.println(alumno + " sale al recreo!");
    }

    public synchronized void tocarConNotify() {
        sonando = true;
        System.out.println("El portero toca el timbre (notify)");
        notify();
    }

    public synchronized void tocarConNotifyAll() {
        sonando = true;
        System.out.println("El portero toca el timbre (notifyAll)");
        notifyAll();
    }

    public synchronized int getAlumnosQueSalen() {
        return alumnosQueSalen;
    }

    public synchronized void liberarATodos() {
        // notify solo despierta a un alumno, asi que despues usamos notifyAll para que los demas no se queden esperando para siempre
        notifyAll();
    }
}
