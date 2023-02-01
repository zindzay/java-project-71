package hexlet.code.formatters;

import hexlet.code.mapper.Node;

import java.util.Map;

public final class StylishFormatter implements Formatter {
    private static final String ADDED = "+ ";
    private static final String DELETED = "- ";
    private static final String UNCHANGED = "  ";
    private static final String DELIMITER = ": ";
    private static final String INDENT = "  ";
    private static final String LINE_SEPARATOR = "\n";

    @Override
    public String format(final Map<String, Node> keyByNode) throws IllegalArgumentException {
        final var sb = new StringBuilder();

        sb.append("{").append(LINE_SEPARATOR);
        for (final var node : keyByNode.entrySet()) {
            sb.append(INDENT);
            switch (node.getValue().type()) {
                case ADDED -> {
                    final var addedString = ADDED + node.getKey() + DELIMITER + node.getValue().newValue();
                    sb.append(addedString);
                }
                case DELETED -> {
                    final var deletedString = DELETED + node.getKey() + DELIMITER + node.getValue().oldValue();
                    sb.append(deletedString);
                }
                case CHANGED -> {
                    final var changedString = DELETED + node.getKey() + DELIMITER + node.getValue().oldValue()
                            + LINE_SEPARATOR + INDENT + ADDED + node.getKey() + DELIMITER + node.getValue().newValue();
                    sb.append(changedString);
                }
                case UNCHANGED -> {
                    final var unchangedString = UNCHANGED + node.getKey() + DELIMITER + node.getValue().oldValue();
                    sb.append(unchangedString);
                }
                default -> throw new IllegalArgumentException("Formatting error in stylish format");
            }
            sb.append(LINE_SEPARATOR);
        }
        sb.append("}");

        return sb.toString();
    }
}
