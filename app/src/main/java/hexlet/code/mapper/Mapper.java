package hexlet.code.mapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class Mapper {
    public static Map<String, Node> map(final Map<String, Object> fileMap1, final Map<String, Object> fileMap2) {
        final Set<String> keys = new TreeSet<>();
        keys.addAll(fileMap1.keySet());
        keys.addAll(fileMap2.keySet());

        final Map<String, Node> differences = new TreeMap<>();
        for (String key : keys) {
            differences.put(key, Node.create(fileMap1, fileMap2, key));
        }

        return differences;
    }
}
