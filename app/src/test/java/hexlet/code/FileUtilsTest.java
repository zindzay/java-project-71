package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystemNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileUtilsTest {

    @Test
    void getExtension() {
        final var extension = FileUtils.getExtension("file.json");

        assertEquals("json", extension);
    }

    @Test
    void getExtensionWithException() {
        final var thrown1 = assertThrows(IllegalArgumentException.class,
                () -> FileUtils.getExtension(null));
        assertEquals("File path can not be null", thrown1.getMessage());

        final var thrown2 = assertThrows(IllegalArgumentException.class,
                () -> FileUtils.getExtension("file"));
        assertEquals("File without extension", thrown2.getMessage());
    }

    @Test
    void read() throws Exception {
        final var file = FileUtils.read("src/test/resources/file3.json");
        assertEquals("{}", file);
    }

    @Test
    void readWithException() {
        final var thrown = assertThrows(FileSystemNotFoundException.class,
                () -> FileUtils.read("file.json"));
        assertEquals("File does not exist", thrown.getMessage());
    }
}
