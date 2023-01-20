package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferTest {

    @Test
    void generate() throws Exception {
        final String actual = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        final String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    void generateWithException() {
        final var thrown = assertThrows(IllegalArgumentException.class,
                () -> Differ.generate("src/test/resources/file1.json",
                        "src/test/resources/file2.yaml", "stylish"));
        assertEquals("Сan not compare different file types", thrown.getMessage());
    }
}
