package hexlet.code.formatters;

import hexlet.code.TestData;
import hexlet.code.mapper.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonFormatterTest {
    private Map<String, Node> keyByNode;
    private String jsonFormatString;

    @BeforeEach
    public void beforeEach() throws Exception {
        var testData = new TestData();
        keyByNode = testData.getNodeMap();
        jsonFormatString = testData.getJsonFormatString();
    }

    @Test
    void format() {
        final String actual = new JsonFormatter().format(keyByNode);
        assertEquals(jsonFormatString, actual);
    }
}
