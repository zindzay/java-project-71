package hexlet.code.parsers;

import hexlet.code.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonParserTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }


    @Test
    void parse() throws Exception {
        final String data = testData.getJson1();
        final Map<String, Object> actual = new JsonParser().parse(data);
        final Map<String, Object> expected = testData.getJson1Map();
        assertEquals(expected, actual);
    }
}
