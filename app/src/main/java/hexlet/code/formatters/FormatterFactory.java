package hexlet.code.formatters;

import hexlet.code.exceptions.UnsupportedOutputFormatException;

public final class FormatterFactory {
    public static Formatter getFormatter(final String name) {
        try {
            return switch (Format.valueOf(name.toUpperCase())) {
                case STYLISH -> new StylishFormatter();
                case PLAIN -> new PlainFormatter();
                case JSON -> new JsonFormatter();
            };
        } catch (Exception e) {
            throw new UnsupportedOutputFormatException("The output format is not supported");
        }
    }
}
