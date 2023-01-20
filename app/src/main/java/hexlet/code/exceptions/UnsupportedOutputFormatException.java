package hexlet.code.exceptions;

public class UnsupportedOutputFormatException extends RuntimeException {
    public UnsupportedOutputFormatException() {
        super();
    }

    public UnsupportedOutputFormatException(String s) {
        super(s);
    }

    public UnsupportedOutputFormatException(String s, Throwable cause) {
        super(s, cause);
    }
}
