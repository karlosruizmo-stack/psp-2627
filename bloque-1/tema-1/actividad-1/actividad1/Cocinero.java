package actividad1;

public class Cocinero {
    private final String name;


    public Cocinero(String name) {
        this.name = name;
    }

    public void ejecutar(ReceiptStep step) {
        step.ejecutar();
        System.out.println("-----------------------------------");
    }

    public String getName() {
        return this.name;
    }
}
