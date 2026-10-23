package actividad1;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ReceiptStep {
    private String description;
    private Container container;
    private List<Ingredient> ingredients;
    private long elapsedTime;


    public ReceiptStep(String description, Container container, List<Ingredient> ingredients) {
        this.description = description;
        this.container = container;
        this.ingredients = ingredients;
        this.elapsedTime =  ThreadLocalRandom.current().nextInt(1, 11) * 1000;

    }

    public void ejecutar() {
        System.out.println("Se está preparando el paso: " + this.description);

        this.container.startUsing();

        this.container.addIngredients(ingredients);

        System.out.println(this.container.toString());

        System.out.println("Todos los ingredientes están dentro de " + this.container.getName() + " , espero " + this.elapsedTime + "ms hasta que estén preparados");

        try {
            Thread.sleep(this.elapsedTime);
        } catch (InterruptedException e) {
            // ignore
        }

        System.out.println("Ya han acabado de hacerse");
        this.container.doneUsing();
    }
}
