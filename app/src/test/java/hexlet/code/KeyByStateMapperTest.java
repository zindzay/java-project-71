package hexlet.code;

import hexlet.code.entry.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyByStateMapperTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void map() {
        final Map<String, Object> file1 = testData.getJson1Map();
        final Map<String, Object> file2 = testData.getJson2Map();
        final Map<String, Entry> expected = testData.getEntryMap();
        final Map<String, Entry> actual = KeyByStateMapper.map(file1, file2);

        assertEquals(expected, actual);
    }
}
