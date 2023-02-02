package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.mapper.Node;

import java.util.Map;

public final class JsonFormatter implements Formatter {
    @Override
    public String format(final Map<String, Node> keyByNode) throws IllegalArgumentException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(keyByNode);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Formatting error in json format. KeyByNode: %s", keyByNode));
        }
    }
}
