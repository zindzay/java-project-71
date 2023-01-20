package hexlet.code.renderers;

import hexlet.code.entry.Entry;
import hexlet.code.entry.State;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StylishRendererTest {

    @Test
    void render() {
        final var oldTimeout = 50;
        final var newTimeout = 20;
        final Map<String, Entry> entryMap = new TreeMap<>();
        entryMap.put("follow", new Entry(false, null, State.DELETED));
        entryMap.put("host", new Entry("hexlet.io", "hexlet.io", State.UNCHANGED));
        entryMap.put("proxy", new Entry("123.234.53.22", null, State.DELETED));
        entryMap.put("timeout", new Entry(oldTimeout, newTimeout, State.CHANGED));
        entryMap.put("verbose", new Entry(null, true, State.ADDED));
        final String actual = new StylishRenderer().render(entryMap);
        final String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, actual);
    }
}
