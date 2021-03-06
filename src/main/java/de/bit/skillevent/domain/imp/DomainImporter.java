package de.bit.skillevent.domain.imp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by pbayer.
 */
public class DomainImporter {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> readData(String fileName, Class<T> c) throws IOException {
        List data =
                mapper.readValue(DomainImporter.class.getClassLoader().getResourceAsStream( fileName), mapper.getTypeFactory().constructCollectionType(List.class, c));
        return data;
    }
}
