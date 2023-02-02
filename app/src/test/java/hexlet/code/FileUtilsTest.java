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
        assertThrows(IllegalArgumentException.class, () -> FileUtils.getExtension(null));
        assertThrows(IllegalArgumentException.class, () -> FileUtils.getExtension("file"));
    }

    @Test
    void read() throws Exception {
        final var file = FileUtils.read("src/test/resources/file3.json");
        assertEquals("{}", file);
    }

    @Test
    void readWithException() {
        assertThrows(FileSystemNotFoundException.class, () -> FileUtils.read("file.json"));
    }
}
