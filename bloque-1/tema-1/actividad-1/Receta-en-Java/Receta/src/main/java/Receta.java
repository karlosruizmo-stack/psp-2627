import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Receta {
    private final String nombre;
    private final List<PasoReceta> pasos = new ArrayList<>();

    public Receta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public void agregarPaso(PasoReceta paso) {
        pasos.add(paso);
    }

    public List<PasoReceta> getPasos() {
        return Collections.unmodifiableList(pasos);
    }


    public void ejecutar(Cocinero cocinero) {

        System.out.println(" Receta: " + nombre + " | Cocinero: " + cocinero.getNombre());
        System.out.println(" Pasos: " + pasos.size() + " (ejecución Secuencial, hilo: "
                + Thread.currentThread().getName() + ")");


        long inicioTotal = System.currentTimeMillis();
        int n = 1;
        for (PasoReceta paso : pasos) {
            System.out.println("\n>>> PASO " + n++ + "/" + pasos.size());
            cocinero.ejecutar(paso);
        }
        long total = System.currentTimeMillis() - inicioTotal;

    }
}