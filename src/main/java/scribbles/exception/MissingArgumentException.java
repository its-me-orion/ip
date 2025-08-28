package scribbles.exception;

public class MissingArgumentException extends ScribblesException {
    public MissingArgumentException(String... params) {
        super("Error: Your command is missing certain arguments...");
    }
}
