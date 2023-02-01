package hexlet.code.formatters;

import hexlet.code.mapper.Node;

import java.util.List;
import java.util.Map;

public final class PlainFormatter implements Formatter {
    private static final String ADDED = " was added ";
    private static final String DELETED = " was removed";
    private static final String CHANGED = " was updated.";
    private static final String PREFIX = "Property ";
    private static final String QUOTE = "'";
    private static final String LINE_SEPARATOR = "\n";
    private static final String WITH_VALUE = "with value: ";
    private static final String FROM = " From ";
    private static final String TO = " to ";
    private static final String NULL = "null";
    private static final String COMPLEX_VALUE = "[complex value]";

    @Override
    public String format(final Map<String, Node> keyByNode) throws IllegalArgumentException {
        final var sb = new StringBuilder();

        for (final var node : keyByNode.entrySet()) {
            final var oldValue = stringify(node.getValue().oldValue());
            final var newValue = stringify(node.getValue().newValue());

            switch (node.getValue().type()) {
                case ADDED -> {
                    final var addedString = PREFIX + QUOTE + node.getKey() + QUOTE + ADDED + WITH_VALUE + newValue;
                    sb.append(addedString);
                }
                case DELETED -> {
                    final var deletedString = PREFIX + QUOTE + node.getKey() + QUOTE + DELETED;
                    sb.append(deletedString);
                }
                case CHANGED -> {
                    final var changedString =
                            PREFIX + QUOTE + node.getKey() + QUOTE + CHANGED + FROM + oldValue + TO + newValue;
                    sb.append(changedString);
                }
                case UNCHANGED -> {
                    continue;
                }
                default -> throw new IllegalArgumentException("Formatting error in plain format");
            }
            sb.append(LINE_SEPARATOR);
        }

        return sb.toString().trim();
    }

    public static String stringify(final Object value) {
        if (value == null) {
            return NULL;
        }

        if (value instanceof String) {
            return QUOTE + value + QUOTE;
        }

        if (value instanceof List || value instanceof Map) {
            return COMPLEX_VALUE;
        }

        return value.toString();
    }
}
