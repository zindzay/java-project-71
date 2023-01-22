package hexlet.code.formatters;

import hexlet.code.exceptions.UnsupportedOutputFormatException;

public final class FormatterFactory {
    public static Formatter getRenderer(final String type) {
        try {
            return switch (Format.valueOf(type.toUpperCase())) {
                case STYLISH -> new StylishFormatter();
                case PLAIN -> new PlainFormatter();
                case JSON -> null;
            };
        } catch (Exception e) {
            throw new UnsupportedOutputFormatException("The output format is not supported");
        }
    }
}
