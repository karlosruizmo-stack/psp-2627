package actividad6;

public class Main {
    public static void main(String[] args) throws Exception {
        long suma = 0;

        for (int n = 1; n <= 8; n++) {
            Canal.enviar(Mensaje.ejecuta(n));

            Mensaje m = Canal.recibir();
            while (m == null || !m.esCompleta()) {
                Thread.sleep(Canal.PAUSA_MS);
                m = Canal.recibir();
            }

            System.out.println("Tarea " + n + " = " + m.resultado);
            suma += m.resultado;
            Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        }

        Canal.enviar(Mensaje.fin());
        System.out.println("Suma = " + suma);   // 108
    }
}