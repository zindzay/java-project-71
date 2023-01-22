package hexlet.code;

import hexlet.code.entry.Entry;
import hexlet.code.entry.State;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class KeyByStateMapper {
    public static Map<String, Entry> map(final Map<String, Object> file1, final Map<String, Object> file2) {
        final Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        final Map<String, Entry> differences = new TreeMap<>();
        for (String key : keys) {
            differences.put(key, createEntry(file1, file2, key));
        }

        return differences;
    }

    private static Entry createEntry(final Map<String, Object> file1, final Map<String, Object> file2,
                                     final String key) {
        var oldValue = file1.getOrDefault(key, null);
        var newValue = file2.getOrDefault(key, null);

        if (!file1.containsKey(key)) {
            return new Entry(null, newValue, State.ADDED);
        } else if (!file2.containsKey(key)) {
            return new Entry(oldValue, null, State.DELETED);
        } else if (Objects.deepEquals(oldValue, newValue)) {
            return new Entry(oldValue, newValue, State.UNCHANGED);
        } else {
            return new Entry(oldValue, newValue, State.CHANGED);
        }
    }
}
