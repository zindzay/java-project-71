package hexlet.code;

import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0-SNAPSHOT",
        description = "Compares two configuration files and shows a difference.")
public class Gendiff implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate("filePath1", "filePath2"));
        return 0;
    }
}
