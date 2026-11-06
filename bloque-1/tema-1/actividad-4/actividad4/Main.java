package actividad4;

public class Main {

    public static void main(String[] args) {

        Recreo recreo1 = new Recreo();

        Thread a1 = new Thread(new Alumno(recreo1, "Alumno 1"));
        Thread a2 = new Thread(new Alumno(recreo1, "Alumno 2"));
        Thread a3 = new Thread(new Alumno(recreo1, "Alumno 3"));
        Thread portero1 = new Thread(new Portero(recreo1, false));

        a1.start();
        a2.start();
        a3.start();
        portero1.start();

        try {
            portero1.join();
            Thread.sleep(500);
            System.out.println("Alumnos que han salido con notify: " + recreo1.getAlumnosQueSalen());
            System.out.println("Los demas siguen esperando, los liberamos con notifyAll");
            recreo1.liberarATodos();
            a1.join();
            a2.join();
            a3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        Recreo recreo2 = new Recreo();

        Thread b1 = new Thread(new Alumno(recreo2, "Alumno 1"));
        Thread b2 = new Thread(new Alumno(recreo2, "Alumno 2"));
        Thread b3 = new Thread(new Alumno(recreo2, "Alumno 3"));
        Thread portero2 = new Thread(new Portero(recreo2, true));

        b1.start();
        b2.start();
        b3.start();
        portero2.start();

        try {
            portero2.join();
            b1.join();
            b2.join();
            b3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Alumnos que han salido con notifyAll: " + recreo2.getAlumnosQueSalen());
    }
}