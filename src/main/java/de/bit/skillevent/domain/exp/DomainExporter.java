package de.bit.skillevent.domain.exp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import de.bit.skillevent.domain.Bestellung;
import de.bit.skillevent.domain.Kunde;
import de.bit.skillevent.domain.Pizza;
import de.bit.skillevent.domain.Zutat;
import org.fluttercode.datafactory.impl.DataFactory;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DomainExporter {

    private static DataFactory  dataFactory;

    public static final int     VEG_PROB = 30;

    private static ObjectWriter objectWriter;

    public static void main(String[] args) throws Exception {

        dataFactory = new DataFactory();

        List<Zutat> zutaten = new ZutatenCreator().alleZutaten();
        List<Pizza> pizzen = new PizzenCreator(zutaten).allePizzen();
        List<Kunde> kunden = new KundenCreator(1000, VEG_PROB).alleKunden();
        List<Bestellung> bestellungen = new BestellungenCreator(kunden, pizzen, 13, 15).alleBestellungen();

        objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        exportToJsonFile(zutaten, "zutaten.json");
        exportToJsonFile(kunden, "kunden.json");
        exportToJsonFile(bestellungen, "bestellungen.json");
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



}
