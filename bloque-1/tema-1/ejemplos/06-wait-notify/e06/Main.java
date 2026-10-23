package e06;

/**
 * wait / notify: el bebé espera a que la comida esté lista.
 * notify() despierta a UNO de los que esperan.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Plato plato = new Plato();

        Thread bebe = new Thread(new Bebe(plato, 3), "bebé");
        Thread cocinero = new Thread(
                new Cocinero(plato, new String[]{"puré", "papilla", "yogur"}),
                "cocinero"
        );

        System.out.println("wait() + notify(): el bebé espera a que la comida esté lista");
        System.out.println("---");
        bebe.start();
        cocinero.start();
        bebe.join();
        cocinero.join();
        System.out.println("---");
        System.out.println("main: fin (bebé saciado)");
    }
}
