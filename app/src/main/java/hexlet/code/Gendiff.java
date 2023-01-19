package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0-SNAPSHOT",
        description = "Compares two configuration files and shows a difference.")
public final class Gendiff implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private File archive;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2));
        return 0;
    }
}
