import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cocinero {
    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private final String nombre;

    public Cocinero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public long ejecutar(PasoReceta paso) {
        Recipiente rec = paso.getRecipiente();

        long inicio = System.currentTimeMillis();
        System.out.println("[" + LocalTime.now().format(HORA) + "] " + nombre + " INICIA: " + paso.getDescripcion());
        System.out.println("   Recipiente : " + rec.getNombre());

        rec.setEstado(EstadoRecipiente.EN_USO);
        for (Ingrediente i : paso.getIngredientes()) {
            rec.anadir(i);
        }
        if (paso.getIngredientes().isEmpty()) {
            System.out.println("   Ingredientes que intervienen: (ninguno nuevo)");
        } else {
            System.out.println("   Ingredientes que intervienen:");
            for (Ingrediente i : paso.getIngredientes()) {
                System.out.println("      - " + i);
            }
        }
        System.out.println("   Duración simulada: " + paso.getDuracionMs() / 1000.0 + " s");

        try {
            Thread.sleep(paso.getDuracionMs()); // "tiempo de cocción"
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("   ¡Paso interrumpido!");
        }

        for (String nombreIng : paso.getARetirar()) {
            rec.retirar(nombreIng);
        }
        rec.setEstado(paso.getEstadoFinal());

        long fin = System.currentTimeMillis();
        long real = fin - inicio;
        System.out.println("[" + LocalTime.now().format(HORA) + "] " + nombre + " TERMINA: " + paso.getDescripcion()
                + " (tardó " + real + " ms)");
        System.out.println("   Estado de " + rec);
        System.out.println("   Contenido  : " + (rec.getContenido().isEmpty() ? "(vacío)" : rec.getContenido()));
        return real;
    }
}