package hexlet.code;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferTest {
    private String outFormatJson;
    private String outFormatStylish;
    private String outFormatPlain;

    @BeforeEach
    public void beforeEach() throws Exception {
        var testData = new TestData();
        outFormatJson = testData.getJsonFormatString();
        outFormatStylish = testData.getStylishFormatString();
        outFormatPlain = testData.getPlainFormatString();
    }

    @Test
    void generate() throws Exception {
        // JSON
        final String actualInJsonOutStylish = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        assertEquals(outFormatStylish, actualInJsonOutStylish);

        final String actualInJsonOutJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        assertEquals(outFormatJson, actualInJsonOutJson);

        final String actualInJsonOutPlain = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain");
        assertEquals(outFormatPlain, actualInJsonOutPlain);

        final String actualInJsonOutDefault = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertEquals(outFormatStylish, actualInJsonOutDefault);
        // YML
        final String actualInYamlOutStylish = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "stylish");
        assertEquals(outFormatStylish, actualInYamlOutStylish);

        final String actualInYamlOutJson = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "json");
        assertEquals(outFormatJson, actualInYamlOutJson);

        final String actualInYamlOutPlain = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "plain");
        assertEquals(outFormatPlain, actualInYamlOutPlain);

        final String actualInYamlOutDefault = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml");
        assertEquals(outFormatStylish, actualInYamlOutDefault);

        final String actualEmpty = Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file3.json");
        final String expectedEmpty = "{\n}";
        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    void generateWithException() {
        assertThrows(IllegalArgumentException.class, () -> Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.yml", "stylish"));

        assertThrows(IllegalArgumentException.class,
                () -> Differ.generate("src/test/resources/file1.json",
                        "src/test/resources/file2.json", "stylish1"));

        assertThrows(FileSystemNotFoundException.class,
                () -> Differ.generate("src/test/resources/file4.json", "src/test/resources/file2.json"));

        assertThrows(MismatchedInputException.class,
                () -> Differ.generate("src/test/resources/empty1.json", "src/test/resources/empty1.json"));
    }
}
