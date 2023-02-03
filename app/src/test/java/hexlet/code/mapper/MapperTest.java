package hexlet.code.mapper;

import hexlet.code.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {
    private Map<String, Object> file1;
    private Map<String, Object> file2;
    private Map<String, Node> nodeMap;

    @BeforeEach
    public void beforeEach() {
        var testData = new TestData();
        file1 = testData.getJson1Map();
        file2 = testData.getJson2Map();
        nodeMap = testData.getNodeMap();
    }

    @Test
    void map() {
        assertEquals(nodeMap, Mapper.map(file1, file2));
    }
}
