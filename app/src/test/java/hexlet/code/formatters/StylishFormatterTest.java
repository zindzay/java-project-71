package hexlet.code.formatters;

import hexlet.code.TestData;
import hexlet.code.mapper.ValuesByState;
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
        final Map<String, ValuesByState> entryMap = testData.getEntryMap();
        final String actual = new StylishFormatter().format(entryMap);
        final String expected = testData.getEntryMapStylishFormatString();
        assertEquals(expected, actual);
    }
}
