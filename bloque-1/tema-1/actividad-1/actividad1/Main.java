package actividad1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cocinero cocinero = new Cocinero("Josue");

        Container pot = new Container("la olla");
        Container pan = new Container("la sarten");

        Ingredient water = new Ingredient("agua", 1, "L");
        Ingredient salt = new Ingredient("sal", 10, "mg");
        Ingredient spaguetis = new Ingredient("espaguetis", 1, "kg");
        Ingredient onion = new Ingredient("cebolla", 1, "u");
        Ingredient garlic = new Ingredient("ajo", 4, "u");
        Ingredient meet = new Ingredient("carne", 500, "g");
        Ingredient tomato = new Ingredient("tomate", 350, "g");

        ReceiptStep step1 = new ReceiptStep(
                "Poner agua a hervir en la olla",
                pot,
                Arrays.asList(water, salt)
        );
        ReceiptStep step2 = new ReceiptStep(
                "Cocer los espaguetis en la olla",
                pot,
                List.of(spaguetis)
        );
        ReceiptStep step3 = new ReceiptStep(
                "Sofreir la cebolla y el ajo en la sartén con aceite",
                pan,
                Arrays.asList(onion, garlic)
        );

        Receipt receipt = new Receipt(
                "Espaguetis a la boloñesa",
                Arrays.asList(
                        step1,
                        step2,
                        step3
                )
        );

        receipt.preparar(cocinero);
    }
}
