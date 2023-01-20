package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public final class JsonParser implements Parser {
    @Override
    public Map<String, Object> parse(final String data) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data, new TypeReference<TreeMap<String, Object>>() {
        });
    }
}
