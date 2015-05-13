package de.bit.skillevent.domain.exp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import de.bit.skillevent.domain.*;
import org.fluttercode.datafactory.impl.DataFactory;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static de.bit.skillevent.domain.exp.DomainExporter.ZUTATEN.*;

public class DomainExporter {

    public enum ZUTATEN {
        SALAMI, SCHINKEN, PILZE, PEPPERONIWURST, MOZZERELLA, PROVOLONE, GOUDA, EDAMER, PARMESAN, BASILIKUM, OREGANO
    };

    public static final int     VEG_PROB = 30;

    private static ObjectWriter objectWriter;

    public static void main(String[] args) throws Exception {

        DataFactory dataFactory = new DataFactory();

        List<Zutat> ingredients = new ArrayList<>();
        ingredients.add(new Zutat(SALAMI.toString(), "Salami", 1.0, false));
        ingredients.add(new Zutat(PEPPERONIWURST.toString(), "Pepperoniwurst", 1.0, false));
        ingredients.add(new Zutat(SCHINKEN.toString(), "Schinken", 1.0, false));
        ingredients.add(new Zutat(PILZE.toString(), "Pilze", 1.0, false));
        ingredients.add(new Zutat(MOZZERELLA.toString(), "Mozzarella", 1.0, false));
        ingredients.add(new Zutat(PROVOLONE.toString(), "Provolone", 1.0, false));
        ingredients.add(new Zutat(GOUDA.toString(), "Gouda", 1.0, false));
        ingredients.add(new Zutat(EDAMER.toString(), "Edamer", 1.0, false));
        ingredients.add(new Zutat(PARMESAN.toString(), "Parmesan", 1.0, false));
        ingredients.add(new Zutat(BASILIKUM.toString(), "Basilikum", 1.0, false));
        ingredients.add(new Zutat(OREGANO.toString(), "Oregano", 1.0, false));

        List<Pizza> pizzen = new ArrayList<>();
        pizzen.add(new PizzaBuilder(new Pizza("1", "Schinken")).withZutat(SCHINKEN).build());
        pizzen.add(new PizzaBuilder(new Pizza("2", "Salami")).withZutat(SALAMI).build());
        pizzen.add(new PizzaBuilder(new Pizza("3", "4 Stragioni")).withZutat(EDAMER).build());
        pizzen.add(new PizzaBuilder(new Pizza("4", "4 Formaggi")).withZutat(EDAMER).withZutat(GOUDA).withZutat(PARMESAN).build());

        List<Rezept> recipes = new ArrayList<>();
        recipes.add(new Rezept("SchinkenPizze").addIngredient("Schinken").addIngredient("Gouda"));

        List<Kunde> customers = new ArrayList<>();
        int i = 0;
        while (i < 1000) {
            customers.add(new Kunde(dataFactory.getFirstName(), dataFactory.getLastName(), dataFactory.chance(VEG_PROB)));
            i++;
        }

        List<Bestellung> orders = new ArrayList<>();

        objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        exportToJsonFile(ingredients, "ingredients.json");
        exportToJsonFile(customers, "customers.json");
        exportToJsonFile(pizzen, "pizzen.json");

    }

    private static void exportToJsonFile(Object data, String fileName) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            objectWriter.writeValue(baos, data);
            writeToFile(fileName, baos);
        }
    }

    private static void writeToFile(String fileName, ByteArrayOutputStream baos) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/" + fileName), StandardCharsets.UTF_8)) {
            writer.write(baos.toString(StandardCharsets.UTF_8.name()));
        }
    }

    private static class PizzaBuilder {

        private Pizza pizza;

        public PizzaBuilder(Pizza pizza) {
            this.pizza = pizza;
        }

        public PizzaBuilder withZutat(Zutat z) {
            pizza.getZutaten().add(new Zutat(z.getOId()));
            return this;
        }

        public PizzaBuilder withZutat(ZUTATEN zutatEnum) {
            pizza.getZutaten().add(new Zutat(zutatEnum.toString()));
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }

}
