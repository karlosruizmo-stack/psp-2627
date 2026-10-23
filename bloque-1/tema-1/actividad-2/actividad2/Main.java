package actividad2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread impresoraThread = new Thread(new Impresora(5), "impresora");
        Thread correoThread = new Thread(new Correo(10), "correo");
        Thread backupThread = new Thread(new Backup(2), "backup");

        System.out.println("Iniciando ordenador y lanzando procesos");

        impresoraThread.start();
        correoThread.start();
        backupThread.start();

        impresoraThread.join();
        correoThread.join();
        backupThread.join();

        System.out.println("Apagando ordenador.");
    }
}

class Impresora extends ComputerThread {
    Impresora(int numPaginas) {
        super(
                "Imprimiendo página ",
                numPaginas,
                200
        );
    }
}

class Correo extends ComputerThread {
    Correo(int numCorreos) {
        super(
                "Leyendo correo ",
                numCorreos,
                500
        );
    }
}

class Backup extends ComputerThread {
    Backup(int nFiles) {
        super(
                "Copiando archivo ",
                nFiles,
                1000
        );
    }
}

abstract class ComputerThread implements Runnable {
    int nUnits;

    String messageTemplate;

    int waitTime;

    ComputerThread(String messageTemplate, int nUnits, int waitTime) {
        this.nUnits = nUnits;
        this.messageTemplate = messageTemplate;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.nUnits; i++) {
            System.out.println(this.messageTemplate + (i + 1));
            pausa(this.waitTime);
        }
    }


    protected static void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}