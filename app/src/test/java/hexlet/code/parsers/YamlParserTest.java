package hexlet.code.parsers;

import hexlet.code.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YamlParserTest {
    private String data;
    private Map<String, Object> map;

    @BeforeEach
    public void beforeEach() throws Exception {
        var testData = new TestData();
        data = testData.getJson1();
        map = testData.getJson1Map();
    }

    @Test
    void parse() throws Exception {
        final Map<String, Object> actual = new YamlParser().parse(data);
        assertEquals(map, actual);
    }
}
