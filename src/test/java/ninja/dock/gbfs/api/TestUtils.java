package ninja.dock.gbfs.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.IOException;

public class TestUtils {

    static <T> T resource(final String name, final Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(Resources.getResource(name), clazz);
        } catch (IOException e) {
            // should not happen
            throw new IllegalStateException(e);
        }
    }
}
