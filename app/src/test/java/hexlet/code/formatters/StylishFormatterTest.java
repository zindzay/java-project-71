package hexlet.code.formatters;

import hexlet.code.TestData;
import hexlet.code.mapper.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StylishFormatterTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void format() {
        final Map<String, Node> keyByNode = testData.getNodeMap();
        final String actual = new StylishFormatter().format(keyByNode);
        final String expected = testData.getStylishFormatString();
        assertEquals(expected, actual);
    }
}
