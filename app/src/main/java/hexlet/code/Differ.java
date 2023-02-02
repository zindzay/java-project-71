package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.mapper.Mapper;
import hexlet.code.parsers.ParserFactory;

import java.util.Map;

public final class Differ {
    public static final String DEFAULT_OUTPUT_FORMAT = "stylish";

    public static String generate(final String filePath1, final String filePath2, final String format)
            throws Exception {
        final var extension1 = FileUtils.getExtension(filePath1);
        final var extension2 = FileUtils.getExtension(filePath2);

        if (!extension1.equals(extension2)) {
            throw new IllegalArgumentException(
                    String.format("Сan not compare different file types, type1: '%s' and type2: '%s'",
                            extension1, extension2));
        }

        final var formatter = FormatterFactory.getFormatter(format);
        final var parser = ParserFactory.getParser(extension1);
        final Map<String, Object> data1 = parser.parse(FileUtils.read(filePath1));
        final Map<String, Object> data2 = parser.parse(FileUtils.read(filePath2));

        return formatter.format(Mapper.map(data1, data2));
    }

    public static String generate(final String filePath1, final String filePath2) throws Exception {
        return generate(filePath1, filePath2, DEFAULT_OUTPUT_FORMAT);
    }
}
