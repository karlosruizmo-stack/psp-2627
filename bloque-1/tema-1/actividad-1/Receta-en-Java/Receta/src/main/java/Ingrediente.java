public class Ingrediente {
    private final String nombre;
    private final double cantidad;
    private final String unidad;

    public Ingrediente(String nombre, double cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return cantidad + " " + unidad + "de" + nombre;
    }
}



