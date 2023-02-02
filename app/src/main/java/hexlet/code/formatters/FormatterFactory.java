package hexlet.code.formatters;

public final class FormatterFactory {
    public static Formatter getFormatter(final String format) {
        return switch (Format.valueOf(format.toUpperCase())) {
            case STYLISH -> new StylishFormatter();
            case PLAIN -> new PlainFormatter();
            case JSON -> new JsonFormatter();
            default -> throw new IllegalArgumentException(String.format("Unknown output format: '%s'", format));
        };
    }
}
