package actividad6;

public class Trabajador {
    public static void main(String[] args) throws Exception {
        while (true) {
            Mensaje m = Canal.recibir();

            if (m != null && m.esFin()) {
                System.out.println("Fin recibido, cierro");
                break;
            }

            if (m != null && m.esEjecuta()) {
                int n = m.tarea;
                System.out.println("Trabajando en la tarea " + n);
                Canal.enviar(Mensaje.trabajando(n));

                Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);

                Canal.enviar(Mensaje.completa(n, n * 3));
            }

            Thread.sleep(Canal.PAUSA_MS);
        }
    }
}