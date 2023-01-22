package hexlet.code.exceptions;

public class UnsupportedFileTypeException extends RuntimeException {
    public UnsupportedFileTypeException(final String s) {
        super(s);
    }
}
