package actividad1;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final String name;

    private ContainerStatus status;

    private final List<Ingredient> ingredients;


    public Container(String name) {
        this.name = name;
        this.status = ContainerStatus.EMPTY;
        this.ingredients = new ArrayList<>();
    }

    public void startUsing() {
        this.status = ContainerStatus.IN_USE;
    }

    public void doneUsing() {
        this.status = ContainerStatus.DONE;
    }

    public void addIngredients(List<Ingredient> ingredients) {
        this.ingredients.addAll(ingredients);
    }

    @Override
    public String toString() {
        StringBuilder ingredients = new StringBuilder();
        for(Ingredient ingredient : this.ingredients) {
            ingredients.append(ingredient.toString()).append(",");
        }
        return this.name + " está " + this.status.toString() + " y los ingredientes: " + ingredients;
    }

    public String getName() {
        return name;
    }
}
