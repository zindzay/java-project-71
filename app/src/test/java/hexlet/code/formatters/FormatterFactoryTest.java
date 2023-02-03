package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatterFactoryTest {

    @ParameterizedTest
    @MethodSource("getTestData")
    void getFormatter(String format, Class<?> formatterClass) {
        assertEquals(formatterClass, FormatterFactory.getFormatter(format).getClass());
    }

    @Test
    void getFormatterWithException() {
        assertThrows(IllegalArgumentException.class, () -> FormatterFactory.getFormatter(""));
    }

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("stylish", StylishFormatter.class),
                Arguments.of("json", JsonFormatter.class),
                Arguments.of("PLAIN", PlainFormatter.class)
        );
    }
}
