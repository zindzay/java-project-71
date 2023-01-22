package hexlet.code;

import hexlet.code.entry.Entry;
import hexlet.code.entry.State;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class TestData {
    private final int oldId = 45;
    private final List<Integer> number1 = List.of(1, 2, 3, 4);
    private final List<Integer> oldNumbers2 = List.of(2, 3, 4, 5);
    private final List<Integer> newNumbers2 = List.of(22, 33, 44, 55);
    private final List<Integer> oldNumbers3 = List.of(3, 4, 5);
    private final List<Integer> newNumbers4 = List.of(4, 5, 6);
    private final List<String> newDefault = List.of("value1", "value2");
    private final List<String>  chars1 = List.of("a", "b", "c");
    private final List<String>  chars2 = List.of("d", "e", "f");
    private final int oldSetting2 = 200;
    private final int newSetting2 = 300;
    private final Map<String, Object> newObj1 = new LinkedHashMap<>();

    public TestData() {
        newObj1.put("nestedKey", "value");
        newObj1.put("isNested", true);
    }

    public Map<String, Entry> getEntryMap() {
        final Map<String, Entry> entryMap = new TreeMap<>();
        entryMap.put("chars1", new Entry(List.of("a", "b", "c"), List.of("a", "b", "c"), State.UNCHANGED));
        entryMap.put("chars2", new Entry(List.of("d", "e", "f"), false, State.CHANGED));
        entryMap.put("checked", new Entry(false, true, State.CHANGED));
        entryMap.put("default", new Entry(null, newDefault, State.CHANGED));
        entryMap.put("id", new Entry(oldId, null, State.CHANGED));
        entryMap.put("key1", new Entry("value1", null, State.DELETED));
        entryMap.put("key2", new Entry(null, "value2", State.ADDED));
        entryMap.put("numbers1", new Entry(number1, number1, State.UNCHANGED));
        entryMap.put("numbers2", new Entry(oldNumbers2, newNumbers2, State.CHANGED));
        entryMap.put("numbers3", new Entry(oldNumbers3, null, State.DELETED));
        entryMap.put("numbers4", new Entry(null, newNumbers4, State.ADDED));
        entryMap.put("obj1", new Entry(null, newObj1, State.ADDED));
        entryMap.put("setting1", new Entry("Some value", "Another value", State.CHANGED));
        entryMap.put("setting2", new Entry(oldSetting2, newSetting2, State.CHANGED));
        entryMap.put("setting3", new Entry(true, "none", State.CHANGED));

        return entryMap;
    }

    public String getEntryMapString() {
        return "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
    }

    public String getJson1() throws Exception {
        return FileUtils.read("src/test/resources/file1.json");
    }

    public String getJson2() throws Exception {
        return FileUtils.read("src/test/resources/file2.json");
    }

    public String getYaml1() throws Exception {
        return FileUtils.read("src/test/resources/file1.yaml");
    }

    public String getYaml2() throws Exception {
        return FileUtils.read("src/test/resources/file2.yaml");
    }

    public Map<String, Object> getJson1Map() {
        final Map<String, Object> json1 = new HashMap<>();
        json1.put("setting1", "Some value");
        json1.put("setting2", oldSetting2);
        json1.put("setting3", true);
        json1.put("key1", "value1");
        json1.put("numbers1", number1);
        json1.put("numbers2", oldNumbers2);
        json1.put("id", oldId);
        json1.put("default", null);
        json1.put("checked", false);
        json1.put("numbers3", oldNumbers3);
        json1.put("chars1", chars1);
        json1.put("chars2", chars2);

        return json1;
    }

    public Map<String, Object> getJson2Map() {
        final Map<String, Object> json2 = new HashMap<>();
        json2.put("setting1", "Another value");
        json2.put("setting2", newSetting2);
        json2.put("setting3", "none");
        json2.put("numbers1", number1);
        json2.put("numbers2", newNumbers2);
        json2.put("id", null);
        json2.put("default", newDefault);
        json2.put("checked", true);
        json2.put("numbers4", newNumbers4);
        json2.put("chars1", chars1);
        json2.put("chars2", false);
        json2.put("obj1", newObj1);
        json2.put("key2", "value2");

        return json2;
    }

    public Map<String, Object> getYaml1Map() {
        return getJson1Map();
    }

    public Map<String, Object> getYaml2Map() {
        return getJson2Map();
    }
}
