package hexlet.code.formatters;

import hexlet.code.mapper.Node;

import java.util.Map;

public final class StylishFormatter implements Formatter {
    @Override
    public String format(final Map<String, Node> keyByNode) throws IllegalArgumentException {
        final var sb = new StringBuilder();

        sb.append("{").append("\n");
        for (final var node : keyByNode.entrySet()) {
            sb.append("  ");
            switch (node.getValue().type()) {
                case ADDED -> sb.append(String.format("+ %s: %s", node.getKey(), node.getValue().newValue()));
                case DELETED -> sb.append(String.format("- %s: %s", node.getKey(), node.getValue().oldValue()));
                case CHANGED -> sb.append(String.format("- %s: %s%n  + %s: %s",
                        node.getKey(), node.getValue().oldValue(), node.getKey(), node.getValue().newValue()));
                case UNCHANGED -> sb.append(String.format("  %s: %s", node.getKey(), node.getValue().oldValue()));
                default -> throw new IllegalArgumentException("Formatting error in stylish format");
            }
            sb.append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}
