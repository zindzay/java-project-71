package hexlet.code;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferTest {
    private String resultJson;
    private String resultStylish;
    private String resultPlain;

    @BeforeEach
    public void beforeEach() throws Exception {
        var testData = new TestData();
        resultJson = testData.getJsonFormatString();
        resultStylish = testData.getStylishFormatString();
        resultPlain = testData.getPlainFormatString();
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml"})
    void generateTest(final String format) throws Exception {
        final String filePath1 = getFixturePath("file1." + format).toString();
        final String filePath2 = getFixturePath("file2." + format).toString();

        assertEquals(resultStylish, Differ.generate(filePath1, filePath2));
        assertEquals(resultStylish, Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(resultPlain, Differ.generate(filePath1, filePath2, "plain"));
        assertEquals(resultJson, Differ.generate(filePath1, filePath2, "json"));
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

    private Path getFixturePath(String file) {
        final var resourcesDir = "src/test/resources/";
        return Paths.get(resourcesDir + file);
    }
}
