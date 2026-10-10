import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasoReceta {
    private final String descripcion;
    private final Recipiente recipiente;
    private final List<Ingrediente> ingredientes;   
    private final List<String> aRetirar;
    private final long duracionMs;
    private final EstadoRecipiente estadoFinal;

    public PasoReceta(String descripcion, Recipiente recipiente, List<Ingrediente> ingredientes,
                      List<String> aRetirar, long duracionMs, EstadoRecipiente estadoFinal) {
        this.descripcion = descripcion;
        this.recipiente = recipiente;
        this.ingredientes = new ArrayList<>(ingredientes);
        this.aRetirar = new ArrayList<>(aRetirar);
        this.duracionMs = duracionMs;
        this.estadoFinal = estadoFinal;
    }

    public String getDescripcion() { return descripcion; }
    public Recipiente getRecipiente() { return recipiente; }
    public List<Ingrediente> getIngredientes() { return Collections.unmodifiableList(ingredientes); }
    public List<String> getARetirar() { return Collections.unmodifiableList(aRetirar); }
    public long getDuracionMs() { return duracionMs; }
    public EstadoRecipiente getEstadoFinal() { return estadoFinal; }
}