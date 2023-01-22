package hexlet.code.formatters;

import hexlet.code.mapper.ValuesByState;

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
    public String format(final Map<String, ValuesByState> entryMap) {
        final var sb = new StringBuilder();

        for (var entry : entryMap.entrySet()) {
            var oldValue = stringify(entry.getValue().oldValue());
            var newValue = stringify(entry.getValue().newValue());

            switch (entry.getValue().state()) {
                case ADDED -> sb.append(PREFIX).append(QUOTE).append(entry.getKey()).append(QUOTE).append(ADDED)
                        .append(WITH_VALUE).append(newValue);
                case DELETED -> sb.append(PREFIX).append(QUOTE).append(entry.getKey()).append(QUOTE).append(DELETED);
                case CHANGED -> sb.append(PREFIX).append(QUOTE).append(entry.getKey()).append(QUOTE).append(CHANGED)
                        .append(FROM).append(oldValue).append(TO)
                        .append(newValue);
                case UNCHANGED -> {
                    continue;
                }
                default -> throw new IllegalArgumentException("Unable to render");
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
