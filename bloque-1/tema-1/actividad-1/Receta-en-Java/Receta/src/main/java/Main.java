import java.util.List;

public class Main {
    public static void main(String[] args) {
        Recipiente olla = new Recipiente("Olla de agua");
        Recipiente sarten = new Recipiente("Sartén grande");
        Recipiente plato = new Recipiente("Plato llano");

        Ingrediente agua = new Ingrediente("Agua", 2000, "ml");
        Ingrediente sal = new Ingrediente("Sal gruesa", 10, "g");
        Ingrediente espaguetis = new Ingrediente("Espaguetis", 400, "g");
        Ingrediente cebolla = new Ingrediente("Cebolla picada", 1, "unidades");
        Ingrediente ajo = new Ingrediente("Ajo", 2, "dientes");
        Ingrediente aceite = new Ingrediente("Aceite de oliva", 30, "ml");
        Ingrediente carne = new Ingrediente("Carne picada", 300, "g");
        Ingrediente tomate = new Ingrediente("Tomate triturado", 400, "g");

        List<Ingrediente> ninguno = List.of();
        List<String> nadaQueRetirar = List.of();


        Receta receta = new Receta("Espaguetis a la boloñesa");

        receta.agregarPaso(new PasoReceta("Poner agua a hervir con sal",
                olla, List.of(agua, sal), nadaQueRetirar, 2000, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Cocer los espaguetis",
                olla, List.of(espaguetis), nadaQueRetirar, 4000, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Sofreír la cebolla y el ajo con aceite",
                sarten, List.of(aceite, cebolla, ajo), nadaQueRetirar, 3000, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Añadir la carne picada y dorarla",
                sarten, List.of(carne), nadaQueRetirar, 2500, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Añadir el tomate y dejar reducir la salsa",
                sarten, List.of(tomate), nadaQueRetirar, 3500, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Escurrir la pasta (se retira el agua)",
                olla, ninguno, List.of("Agua", "Sal gruesa"), 1000, EstadoRecipiente.EN_USO));

        receta.agregarPaso(new PasoReceta("Mezclar la pasta con la salsa boloñesa",
                sarten, List.of(new Ingrediente("Espaguetis cocidos", 400, "g")),
                nadaQueRetirar, 1500, EstadoRecipiente.TERMINADO));

        receta.agregarPaso(new PasoReceta("Emplatar",
                plato, List.of(new Ingrediente("Espaguetis a la boloñesa", 1, "ración")),
                nadaQueRetirar, 500, EstadoRecipiente.TERMINADO));

        Cocinero cocinero = new Cocinero("Chef Carlos");
        receta.ejecutar(cocinero);
    }
}