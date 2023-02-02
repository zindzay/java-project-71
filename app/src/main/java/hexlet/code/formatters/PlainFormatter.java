package hexlet.code.formatters;

import hexlet.code.mapper.Node;

import java.util.List;
import java.util.Map;

public final class PlainFormatter implements Formatter {
    private static final String NULL_VALUE = "null";
    private static final String COMPLEX_VALUE = "[complex value]";

    @Override
    public String format(final Map<String, Node> keyByNode) throws IllegalArgumentException {
        final var sb = new StringBuilder();

        for (final var node : keyByNode.entrySet()) {
            final var oldValue = stringify(node.getValue().oldValue());
            final var newValue = stringify(node.getValue().newValue());

            switch (node.getValue().type()) {
                case ADDED ->
                        sb.append(String.format("Property '%s' was added with value: %s", node.getKey(), newValue));
                case DELETED -> sb.append(String.format("Property '%s' was removed", node.getKey()));
                case CHANGED -> sb.append(String.format("Property '%s' was updated. From %s to %s",
                        node.getKey(), oldValue, newValue));
                case UNCHANGED -> {
                    continue;
                }
                default -> throw new IllegalArgumentException(
                        String.format("Formatting error in plain format. KeyByNode: %s", keyByNode));
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }

    public static String stringify(final Object value) {
        if (value == null) {
            return NULL_VALUE;
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof List || value instanceof Map) {
            return COMPLEX_VALUE;
        }

        return value.toString();
    }
}
