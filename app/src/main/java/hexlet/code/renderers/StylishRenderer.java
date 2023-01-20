package hexlet.code.renderers;

import hexlet.code.entry.Entry;

import java.util.Map;

public final class StylishRenderer implements Renderer {
    private static final String ADDED = "+ ";
    private static final String DELETED = "- ";
    private static final String UNCHANGED = "  ";
    private static final String DELIMITER = ": ";
    private static final String INDENT = "  ";
    private static final String LINE_SEPARATOR = "\n";

    @Override
    public String render(final Map<String, Entry> entryMap) throws IllegalArgumentException {
        var sb = new StringBuilder();

        sb.append("{").append(LINE_SEPARATOR);
        for (var entry : entryMap.entrySet()) {
            sb.append(INDENT);
            switch (entry.getValue().state()) {
                case ADDED ->
                        sb.append(ADDED).append(entry.getKey()).append(DELIMITER).append(entry.getValue().newValue());
                case DELETED ->
                        sb.append(DELETED).append(entry.getKey()).append(DELIMITER).append(entry.getValue().oldValue());
                case CHANGED -> {
                    sb.append(DELETED).append(entry.getKey()).append(DELIMITER).append(entry.getValue().oldValue());
                    sb.append(LINE_SEPARATOR).append(INDENT);
                    sb.append(ADDED).append(entry.getKey()).append(DELIMITER).append(entry.getValue().newValue());
                }
                case UNCHANGED -> sb.append(UNCHANGED).append(entry.getKey()).append(DELIMITER)
                        .append(entry.getValue().oldValue());
                default -> throw new IllegalArgumentException("Unable to render");
            }
            sb.append(LINE_SEPARATOR);
        }
        sb.append("}");

        return sb.toString();
    }
}
