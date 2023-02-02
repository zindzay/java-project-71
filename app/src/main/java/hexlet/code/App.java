package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.DEFAULT_OUTPUT_FORMAT;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0-SNAPSHOT",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    private static final int OK_CODE = 0;
    private static final int ERROR_CODE = -1;

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]",
            defaultValue = DEFAULT_OUTPUT_FORMAT)
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Override
    public final Integer call() {
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
            return OK_CODE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ERROR_CODE;
        }
    }

    public static void main(String[] args) {
        System.exit(new CommandLine(new App()).execute(args));
    }
}
