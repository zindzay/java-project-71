package hexlet.code.parsers;

import hexlet.code.exceptions.UnsupportedFileTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserFactoryTest {

    @Test
    void getParser() {
        final Parser parser = ParserFactory.getParser("json");
        assertEquals(JsonParser.class, parser.getClass());
    }

    @Test
    void getParserWithException() {
        final var thrown = assertThrows(UnsupportedFileTypeException.class,
                () -> ParserFactory.getParser(""));
        assertEquals("The file is not supported", thrown.getMessage());
    }
}
