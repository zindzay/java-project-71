package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferTest {
    private TestData testData;

    @BeforeEach
    public void beforeEach() {
        testData = new TestData();
    }

    @Test
    void generate() throws Exception {
        final String actual = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        final String expected = testData.getEntryMapStylishFormatString();
        assertEquals(expected, actual);

        final String actualWithDefault = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertEquals(expected, actualWithDefault);
    }

    @Test
    void generateWithException() {
        final var thrown = assertThrows(IllegalArgumentException.class,
                () -> Differ.generate("src/test/resources/file1.json",
                        "src/test/resources/file2.yml", "stylish"));
        assertEquals("Сan not compare different file types", thrown.getMessage());
    }
}
