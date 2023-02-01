package hexlet.code.mapper;

import hexlet.code.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void map() {
        final Map<String, Object> file1 = testData.getJson1Map();
        final Map<String, Object> file2 = testData.getJson2Map();
        final Map<String, Node> expected = testData.getNodeMap();
        final Map<String, Node> actual = Mapper.map(file1, file2);

        assertEquals(expected, actual);
    }
}
