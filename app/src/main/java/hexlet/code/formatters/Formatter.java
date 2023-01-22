package hexlet.code.formatters;

import hexlet.code.mapper.Node;

import java.util.Map;

public interface Formatter {
    String format(Map<String, Node> keyByNode) throws IllegalArgumentException;
}
