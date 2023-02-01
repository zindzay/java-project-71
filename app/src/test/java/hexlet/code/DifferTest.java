package hexlet.code;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import hexlet.code.exceptions.UnsupportedOutputFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemNotFoundException;

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
        final String actualJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        final String expectedStylishFormatter = testData.getStylishFormatString();
        assertEquals(expectedStylishFormatter, actualJson);

        final String actualYml = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml");
        assertEquals(expectedStylishFormatter, actualYml);

        final String actualPlainFormatter = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "plain");
        final String expectedPlaynFormatter = testData.getPlainFormatString();
        assertEquals(expectedPlaynFormatter, actualPlainFormatter);

        final String actualJsonFormatFormatter = Differ.generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "json");
        final String expectedJsonFormatter = testData.getJsonFormatString();
        assertEquals(expectedJsonFormatter, actualJsonFormatFormatter);

        final String actualDefaultFormatter = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertEquals(expectedStylishFormatter, actualDefaultFormatter);

        final String actualEmpty = Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file3.json");
        final String expectedEmpty = "{\n}";
        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    void generateWithException() {
        final var thrown1 = assertThrows(IllegalArgumentException.class,
                () -> Differ.generate("src/test/resources/file1.json",
                        "src/test/resources/file2.yml", "stylish"));
        assertEquals("Сan not compare different file types", thrown1.getMessage());

        final var thrown2 = assertThrows(UnsupportedOutputFormatException.class,
                () -> Differ.generate("src/test/resources/file1.json",
                        "src/test/resources/file2.json", "stylish1"));
        assertEquals("The output format is not supported", thrown2.getMessage());

        final var thrown3 = assertThrows(FileSystemNotFoundException.class,
                () -> Differ.generate("src/test/resources/file4.json", "src/test/resources/file2.json"));
        assertEquals("File does not exist", thrown3.getMessage());

        assertThrows(MismatchedInputException.class,
                () -> Differ.generate("src/test/resources/empty1.json", "src/test/resources/empty1.json"));
    }
}
