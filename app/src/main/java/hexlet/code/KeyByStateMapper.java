package hexlet.code;

import hexlet.code.entry.Entry;
import hexlet.code.entry.State;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class KeyByStateMapper {
    public static Map<String, Entry> map(final Map<String, Object> file1, final Map<String, Object> file2) {
        final Map<String, Entry> differences = new TreeMap<>();

        final Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        for (String key : keys) {
            var oldValue = file1.getOrDefault(key, null);
            var newValue = file2.getOrDefault(key, null);

            if (oldValue == null) {
                differences.put(key, new Entry(null, newValue, State.ADDED));
            } else if (newValue == null) {
                differences.put(key, new Entry(oldValue, null, State.DELETED));
            } else if (oldValue.equals(newValue)) {
                differences.put(key, new Entry(oldValue, newValue, State.UNCHANGED));
            } else {
                differences.put(key, new Entry(oldValue, newValue, State.CHANGED));
            }
        }

        return differences;
    }
}
