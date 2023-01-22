package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YamlParserTest {

    @Test
    void parse() throws JsonProcessingException {
        final String data = "host: hexlet.io\n"
                + "timeout: 50\n"
                + "proxy: \"123.234.53.22\"\n"
                + "\"follow\":\n"
                + "  false";
        final Map<String, Object> actual = new YamlParser().parse(data);
        final Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false);
        assertEquals(expected, actual);
    }
}
