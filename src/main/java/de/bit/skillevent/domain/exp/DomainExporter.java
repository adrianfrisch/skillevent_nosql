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

public class DomainExporter {

    public static final int VEG_PROB = 30;

    private static ObjectWriter objectWriter;

    public static void main(String[] args) throws Exception {

        DataFactory dataFactory = new DataFactory();

        List<Zutat> ingredients = new ArrayList<>();
        ingredients.add(new Zutat("Salami", 1.0, false));
        ingredients.add(new Zutat("Pepperoniwurst", 1.0, false));
        ingredients.add(new Zutat("Schinken", 1.0, false));
        ingredients.add(new Zutat("Pilze", 1.0, false));
        ingredients.add(new Zutat("Mozzarella", 1.0, false));
        ingredients.add(new Zutat("Provolone", 1.0, false));
        ingredients.add(new Zutat("Gouda", 1.0, false));
        ingredients.add(new Zutat("Edamer", 1.0, false));
        ingredients.add(new Zutat("Parmesan", 1.0, false));
        ingredients.add(new Zutat("Basilikum", 1.0, false));
        ingredients.add(new Zutat("Oregano", 1.0, false));

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Schinken"));
        pizzas.add(new Pizza("Salami"));
        pizzas.add(new Pizza("4 Stragioni"));
        pizzas.add(new Pizza("4 Formaggi"));

        List<Rezept> recipies = new ArrayList<>();
        recipies.add(new Rezept("schinken").addIngredient("schinken").addIngredient("gouda"));

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
}
