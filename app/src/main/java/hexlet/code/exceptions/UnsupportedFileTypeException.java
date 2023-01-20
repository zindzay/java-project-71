package hexlet.code.exceptions;

public class UnsupportedFileTypeException extends RuntimeException {
    public UnsupportedFileTypeException() {
        super();
    }

    public UnsupportedFileTypeException(String s) {
        super(s);
    }

    public UnsupportedFileTypeException(String s, Throwable cause) {
        super(s, cause);
    }
}
