package hexlet.code.formatters;

import hexlet.code.TestData;
import hexlet.code.mapper.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainFormatterTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void format() {
        final Map<String, Node> keyByNode = testData.getNodeMap();
        final String actual = new PlainFormatter().format(keyByNode);
        final String expected = testData.getPlainFormatString();
        assertEquals(expected, actual);
    }
}
