package ScribblesExceptions;

public class MissingDescriptionException extends ScribblesException {
    public MissingDescriptionException() {
        super("Error: Your task is missing a description! D:");
    }
}
