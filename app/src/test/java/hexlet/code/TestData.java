package hexlet.code;

import hexlet.code.mapper.Type;
import hexlet.code.mapper.Node;

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
    private final List<String> chars1 = List.of("a", "b", "c");
    private final List<String> chars2 = List.of("d", "e", "f");
    private final int oldSetting2 = 200;
    private final int newSetting2 = 300;
    private final Map<String, Object> newObj1 = new LinkedHashMap<>();

    public TestData() {
        newObj1.put("nestedKey", "value");
        newObj1.put("isNested", true);
    }

    public Map<String, Node> getNodeMap() {
        final Map<String, Node> keyByNode = new TreeMap<>();
        keyByNode.put("chars1", new Node(List.of("a", "b", "c"), List.of("a", "b", "c"), Type.UNCHANGED));
        keyByNode.put("chars2", new Node(List.of("d", "e", "f"), false, Type.CHANGED));
        keyByNode.put("checked", new Node(false, true, Type.CHANGED));
        keyByNode.put("default", new Node(null, newDefault, Type.CHANGED));
        keyByNode.put("id", new Node(oldId, null, Type.CHANGED));
        keyByNode.put("key1", new Node("value1", null, Type.DELETED));
        keyByNode.put("key2", new Node(null, "value2", Type.ADDED));
        keyByNode.put("numbers1", new Node(number1, number1, Type.UNCHANGED));
        keyByNode.put("numbers2", new Node(oldNumbers2, newNumbers2, Type.CHANGED));
        keyByNode.put("numbers3", new Node(oldNumbers3, null, Type.DELETED));
        keyByNode.put("numbers4", new Node(null, newNumbers4, Type.ADDED));
        keyByNode.put("obj1", new Node(null, newObj1, Type.ADDED));
        keyByNode.put("setting1", new Node("Some value", "Another value", Type.CHANGED));
        keyByNode.put("setting2", new Node(oldSetting2, newSetting2, Type.CHANGED));
        keyByNode.put("setting3", new Node(true, "none", Type.CHANGED));

        return keyByNode;
    }

    public String getStylishFormatString() throws Exception {
        return FileUtils.read("src/test/resources/stylishFormatString");
    }

    public String getPlainFormatString() throws Exception {
        return FileUtils.read("src/test/resources/plainFormatString");
    }

    public String getJsonFormatString() throws Exception {
        return FileUtils.read("src/test/resources/jsonFormatString");
    }

    public String getJson1() throws Exception {
        return FileUtils.read("src/test/resources/file1.json");
    }

    public String getJson2() throws Exception {
        return FileUtils.read("src/test/resources/file2.json");
    }

    public String getYaml1() throws Exception {
        return FileUtils.read("src/test/resources/file1.yml");
    }

    public String getYaml2() throws Exception {
        return FileUtils.read("src/test/resources/file2.yml");
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
