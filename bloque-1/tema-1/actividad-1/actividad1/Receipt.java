package actividad1;

import java.util.List;

public class Receipt {
    private final String name;
    private final List<ReceiptStep> steps;

    public Receipt(String name, List<ReceiptStep> steps) {
        this.name = name;
        this.steps = steps;
    }


    public void preparar(Cocinero cocinero) {
        Long start = System.currentTimeMillis();

        System.out.println(cocinero.getName()  + " ha empezado a preparar " + this.name );

        for(ReceiptStep step : steps) {
            cocinero.ejecutar(step);
        }

        Long end = System.currentTimeMillis();
        Long duration = (end - start) / 1000;

        System.out.println(cocinero.getName()  + " ha acabado la receta. Ha tardado: " + duration + " segundos");
    }
}
