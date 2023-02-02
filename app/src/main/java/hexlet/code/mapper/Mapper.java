package hexlet.code.mapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class Mapper {
    public static Map<String, Node> map(final Map<String, Object> data1, final Map<String, Object> data2) {
        final Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        final Map<String, Node> differences = new TreeMap<>();
        for (String key : keys) {
            differences.put(key, Node.create(data1, data2, key));
        }

        return differences;
    }
}
