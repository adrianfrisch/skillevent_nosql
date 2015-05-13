package de.bit.skillevent.domain.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bit.skillevent.domain.Kunde;
import de.bit.skillevent.domain.Pizza;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by pbayer.
 */
public class DomainImporter {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        readData();
    }

    public static <T> List<T> readData(String fileName, Class<T> c) throws IOException {
        List data = mapper.readValue(new File("src/main/resources/" + fileName), mapper.getTypeFactory().constructCollectionType(List.class, c));
        return data;
    }
}
