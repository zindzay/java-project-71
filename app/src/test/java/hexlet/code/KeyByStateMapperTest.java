package hexlet.code;

import hexlet.code.entry.Entry;
import hexlet.code.entry.State;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyByStateMapperTest {

    @Test
    void map() {
        final Map<String, Object> file1 = Map.of(
                "host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false
        );
        final Map<String, Object> file2 = Map.of(
                "timeout", 20,
                "verbose", true,
                "host", "hexlet.io"
        );
        final Map<String, Entry> actual = KeyByStateMapper.map(file1, file2);
        final Map<String, Entry> expected = Map.of(
                "follow", new Entry(false, null, State.DELETED),
                "host", new Entry("hexlet.io", "hexlet.io", State.UNCHANGED),
                "proxy", new Entry("123.234.53.22", null, State.DELETED),
                "timeout", new Entry(50, 20, State.CHANGED),
                "verbose", new Entry(null, true, State.ADDED)
        );
        assertEquals(expected, actual);
    }
}
