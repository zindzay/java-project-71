package hexlet.code.mapper;

import java.util.Map;
import java.util.Objects;

public record Node(Object oldValue, Object newValue, Type type) {
    public static Node create(final Map<String, Object> fileMap1, final Map<String, Object> fileMap2,
                              final String key) {
        final var oldValue = fileMap1.getOrDefault(key, null);
        final var newValue = fileMap2.getOrDefault(key, null);

        if (!fileMap1.containsKey(key)) {
            return new Node(null, newValue, Type.ADDED);
        } else if (!fileMap2.containsKey(key)) {
            return new Node(oldValue, null, Type.DELETED);
        } else if (Objects.deepEquals(oldValue, newValue)) {
            return new Node(oldValue, newValue, Type.UNCHANGED);
        } else {
            return new Node(oldValue, newValue, Type.CHANGED);
        }
    }
}
