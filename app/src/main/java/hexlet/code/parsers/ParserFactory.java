package hexlet.code.parsers;

public final class ParserFactory {
    public static Parser getParser(final String format) {
        return switch (Format.valueOf(format.toUpperCase())) {
            case JSON -> new JsonParser();
            case YML, YAML -> new YamlParser();
            default -> throw new IllegalArgumentException(String.format("Unknown format: '%s'", format));
        };
    }
}
