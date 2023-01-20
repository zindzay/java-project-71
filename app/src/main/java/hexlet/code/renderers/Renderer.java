package hexlet.code.renderers;

import hexlet.code.entry.Entry;

import java.util.Map;

public interface Renderer {
    String render(Map<String, Entry> entryMap);
}
