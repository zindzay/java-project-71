package hexlet.code.formatters;

import hexlet.code.exceptions.UnsupportedOutputFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatterFactoryTest {

    @Test
    void getFormatter() {
        final Formatter stylishFormatter = FormatterFactory.getFormatter("stylish");
        assertEquals(StylishFormatter.class, stylishFormatter.getClass());
        final Formatter jsonFormatter = FormatterFactory.getFormatter("json");
        assertEquals(JsonFormatter.class, jsonFormatter.getClass());
        final Formatter plainFormatter = FormatterFactory.getFormatter("PLAIN");
        assertEquals(PlainFormatter.class, plainFormatter.getClass());
    }

    @Test
    void getFormatterWithException() {
        final var thrown = assertThrows(UnsupportedOutputFormatException.class,
                () -> FormatterFactory.getFormatter(""));
        assertEquals("The output format is not supported", thrown.getMessage());
    }
}
