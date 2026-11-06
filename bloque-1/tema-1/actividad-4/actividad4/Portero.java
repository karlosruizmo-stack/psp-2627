package actividad4;

public class Portero implements Runnable {

    private Recreo recreo;
    private boolean usarNotifyAll;

    public Portero(Recreo recreo, boolean usarNotifyAll) {
        this.recreo = recreo;
        this.usarNotifyAll = usarNotifyAll;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (usarNotifyAll) {
            recreo.tocarConNotifyAll();
        } else {
            recreo.tocarConNotify();
        }
    }
}
