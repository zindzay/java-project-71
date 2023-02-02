package hexlet.code.formatters;

import hexlet.code.TestData;
import hexlet.code.mapper.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainFormatterTest {
    private Map<String, Node> keyByNode;
    private String plainFormatString;

    @BeforeEach
    public void beforeEach() throws Exception {
        var testData = new TestData();
        keyByNode = testData.getNodeMap();
        plainFormatString = testData.getPlainFormatString();
    }

    @Test
    void format() {
        final String actual = new PlainFormatter().format(keyByNode);
        assertEquals(plainFormatString, actual);
    }
}
