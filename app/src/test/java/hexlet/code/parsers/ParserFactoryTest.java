package hexlet.code.parsers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserFactoryTest {

    @ParameterizedTest
    @MethodSource("getTestData")
    void getParser(String format, Class<?> parserClass) {
        assertEquals(parserClass, ParserFactory.getParser(format).getClass());
    }

    @Test
    void getParserWithException() {
        assertThrows(IllegalArgumentException.class, () -> ParserFactory.getParser(""));
    }

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("json", JsonParser.class),
                Arguments.of("yml", YamlParser.class),
                Arguments.of("yaml", YamlParser.class)
        );
    }
}
