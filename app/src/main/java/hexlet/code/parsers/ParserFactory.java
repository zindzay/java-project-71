package hexlet.code.parsers;

import hexlet.code.exceptions.UnsupportedFileTypeException;

public final class ParserFactory {
    public static Parser getParser(final String type) {
        try {
            return switch (Extension.valueOf(type.toUpperCase())) {
                case JSON -> new JsonParser();
                case YML -> new YamlParser();
            };
        } catch (Exception e) {
            throw new UnsupportedFileTypeException("The file is not supported");
        }
    }
}
