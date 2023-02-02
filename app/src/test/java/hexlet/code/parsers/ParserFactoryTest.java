package hexlet.code.parsers;

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
        assertThrows(IllegalArgumentException.class, () -> ParserFactory.getParser(""));
    }
}
