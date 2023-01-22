package hexlet.code.formatters;

import hexlet.code.exceptions.UnsupportedOutputFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatterFactoryTest {

    @Test
    void getRenderer() {
        final Formatter formatter = FormatterFactory.getRenderer("stylish");
        assertEquals(StylishFormatter.class, formatter.getClass());
    }

    @Test
    void getRendererWithException() {
        final var thrown = assertThrows(UnsupportedOutputFormatException.class,
                () -> FormatterFactory.getRenderer(""));
        assertEquals("The output format is not supported", thrown.getMessage());
    }
}
