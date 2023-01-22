package hexlet.code.parsers;

import hexlet.code.exceptions.UnsupportedFileTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserFactoryTest {

    @Test
    void getParser() {
        final Parser jsonpParser = ParserFactory.getParser("json");
        assertEquals(JsonParser.class, jsonpParser.getClass());

        final Parser yamlParser = ParserFactory.getParser("YML");
        assertEquals(YamlParser.class, yamlParser.getClass());
    }

    @Test
    void getParserWithException() {
        final var thrown = assertThrows(UnsupportedFileTypeException.class,
                () -> ParserFactory.getParser(""));
        assertEquals("The file is not supported", thrown.getMessage());
    }
}
