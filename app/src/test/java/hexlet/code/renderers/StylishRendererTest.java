package hexlet.code.renderers;

import hexlet.code.TestData;
import hexlet.code.entry.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StylishRendererTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void render() {
        final Map<String, Entry> entryMap = testData.getEntryMap();
        final String actual = new StylishRenderer().render(entryMap);
        final String expected = testData.getEntryMapString();
        assertEquals(expected, actual);
    }
}
