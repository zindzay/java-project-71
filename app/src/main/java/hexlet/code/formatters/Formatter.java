package hexlet.code.formatters;

import hexlet.code.mapper.ValuesByState;

import java.util.Map;

public interface Formatter {
    String format(Map<String, ValuesByState> entryMap);
}
