package hexlet.code.mapper;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class KeyByStateMapper {
    public static Map<String, ValuesByState> map(final Map<String, Object> file1, final Map<String, Object> file2) {
        final Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        final Map<String, ValuesByState> differences = new TreeMap<>();
        for (String key : keys) {
            differences.put(key, createEntry(file1, file2, key));
        }

        return differences;
    }

    private static ValuesByState createEntry(final Map<String, Object> file1, final Map<String, Object> file2,
                                             final String key) {
        var oldValue = file1.getOrDefault(key, null);
        var newValue = file2.getOrDefault(key, null);

        if (!file1.containsKey(key)) {
            return new ValuesByState(null, newValue, State.ADDED);
        } else if (!file2.containsKey(key)) {
            return new ValuesByState(oldValue, null, State.DELETED);
        } else if (Objects.deepEquals(oldValue, newValue)) {
            return new ValuesByState(oldValue, newValue, State.UNCHANGED);
        } else {
            return new ValuesByState(oldValue, newValue, State.CHANGED);
        }
    }
}
