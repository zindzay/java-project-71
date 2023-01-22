package hexlet.code;

import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtils {
    private static final char EXTENSION_SEPARATOR = '.';

    public static String read(final String filepath) throws Exception {
        final Path path = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new FileSystemNotFoundException("File does not exist");
        }

        return Files.readString(path);
    }

    public static String getExtension(final String filepath) throws IllegalArgumentException {
        if (filepath == null) {
            throw new IllegalArgumentException("File path can not be null");
        }

        final int index = filepath.lastIndexOf(EXTENSION_SEPARATOR);

        if (index == -1) {
            throw new IllegalArgumentException("File without extension");
        }

        return filepath.substring(index + 1);
    }
}
