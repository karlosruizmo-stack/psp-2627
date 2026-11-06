import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipiente {
    private final String nombre;
    public EstadoRecipiente estado;
    private final List<Ingrediente> contenido;

    public Recipiente(String nombre) {
        this.nombre = nombre;
        this.estado = EstadoRecipiente.VACIO;
        this.contenido = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public EstadoRecipiente getEstado() { return estado; }
    public void setEstado(EstadoRecipiente Lleno) { this.estado = estado; }

    public List<Ingrediente> getContenido() {
        return Collections.unmodifiableList(contenido);
    }

    public void anadir(Ingrediente ingrediente) {
        contenido.add(ingrediente);
    }


    public void retirar(String nombreIngrediente) {
        contenido.removeIf(i -> i.getNombre().equalsIgnoreCase(nombreIngrediente));
    }

    public void vaciar() {
        contenido.clear();
    }

    @Override
    public String toString() {
        return nombre + " [" + estado + "]";
    }
}
