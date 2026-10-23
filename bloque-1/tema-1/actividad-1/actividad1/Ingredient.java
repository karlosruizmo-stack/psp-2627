package actividad1;

public class Ingredient {
    private String name;

    private Integer quantity;

    private String unity;


    public Ingredient(String name, Integer quantity, String unity) {
        this.name = name;
        this.quantity = quantity;
        this.unity = unity;
    }

    @Override
    public String toString() {
        return this.name + " " + this.quantity + " " + this.unity;
    }
}
