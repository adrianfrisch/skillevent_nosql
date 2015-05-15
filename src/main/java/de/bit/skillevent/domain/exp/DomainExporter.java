package de.bit.skillevent.domain.exp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Lists;
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
import java.util.UUID;

import static de.bit.skillevent.domain.exp.DomainExporter.ZUTATEN.*;

public class DomainExporter {

    private static DataFactory dataFactory;

    private static List<Pizza> pizzen;

    private static List<Zutat> zutaten;

    public enum ZUTATEN {
        SALAMI, SCHINKEN, PILZE, PEPPERONIWURST, MOZZERELLA, PROVOLONE, GOUDA, EDAMER, PARMESAN, BASILIKUM, OREGANO
    }

    public static final int VEG_PROB = 30;

    private static ObjectWriter objectWriter;

    public static void main(String[] args) throws Exception {

        dataFactory = new DataFactory();

        zutaten = new ArrayList<>();
        zutaten.add(new Zutat(SALAMI.toString(), "Salami", 1.0, false));
        zutaten.add(new Zutat(PEPPERONIWURST.toString(), "Pepperoniwurst", 1.0, false));
        zutaten.add(new Zutat(SCHINKEN.toString(), "Schinken", 1.0, false));
        zutaten.add(new Zutat(PILZE.toString(), "Pilze", 1.0, false));
        zutaten.add(new Zutat(MOZZERELLA.toString(), "Mozzarella", 1.0, false));
        zutaten.add(new Zutat(PROVOLONE.toString(), "Provolone", 1.0, false));
        zutaten.add(new Zutat(GOUDA.toString(), "Gouda", 1.0, false));
        zutaten.add(new Zutat(EDAMER.toString(), "Edamer", 1.0, false));
        zutaten.add(new Zutat(PARMESAN.toString(), "Parmesan", 1.0, false));
        zutaten.add(new Zutat(BASILIKUM.toString(), "Basilikum", 1.0, false));
        zutaten.add(new Zutat(OREGANO.toString(), "Oregano", 1.0, false));

        pizzen = new ArrayList<>();
        pizzen.add(new PizzaBuilder(new Pizza("1", "Schinken")).withZutat(SCHINKEN).build());
        pizzen.add(new PizzaBuilder(new Pizza("2", "Salami")).withZutat(SALAMI).build());
        pizzen.add(new PizzaBuilder(new Pizza("3", "4 Stragioni")).withZutat(EDAMER).build());
        pizzen.add(new PizzaBuilder(new Pizza("4", "4 Formaggi")).withZutat(EDAMER).withZutat(GOUDA).withZutat(PARMESAN).build());

        List<Kunde> kunden = new ArrayList<>();
        int i = 0;
        while (i < 1000) {
            kunden.add(new Kunde(UUID.randomUUID().toString(), dataFactory.getFirstName(), dataFactory.getLastName(), dataFactory
                    .chance(VEG_PROB)));
            i++;
        }

        List<Bestellung> bestellungen = new ArrayList<>();

        kunden.forEach(k -> {
            int anzBestellungen, j = 0;
            anzBestellungen = dataFactory.getNumberBetween(1, 13);
            while (j < anzBestellungen) {
                bestellungen.add(createBestellung(k));
                j++;
            }
        });

        objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        exportToJsonFile(zutaten, "zutaten.json");
        exportToJsonFile(kunden, "kunden.json");
        exportToJsonFile(bestellungen, "bestellungen.json");
        exportToJsonFile(pizzen, "pizzen.json");

    }

    private static Bestellung createBestellung(Kunde kunde) {
        int anzPizzen = dataFactory.getNumberBetween(1, 15);
        List<Pizza> bestelletePizzen = Lists.newArrayList();
        for (int i = 0; i < anzPizzen; i++) {
            bestelletePizzen.add(dataFactory.getItem(pizzen));
        }
        double preisPizzen = bestelletePizzen.stream().mapToDouble(p -> {
            return p.getZutaten().stream().mapToDouble(Zutat::getPreis).sum();
        }).sum();

        Bestellung bestellung = new Bestellung(kunde, preisPizzen);
        bestellung.setBestelltePizzen(bestelletePizzen);
        return bestellung;
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

        public PizzaBuilder withZutat(ZUTATEN zutat) {
            pizza.getZutaten().add(zutaten.stream().filter(z -> {
                return z.getOId().equals(zutat.toString());
            }).findFirst().get());
            return this;
        }

        public Pizza build() {
            return pizza;
        }

    }

}
