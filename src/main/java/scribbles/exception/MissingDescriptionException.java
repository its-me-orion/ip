package scribbles.exception;

/**
 * Provides exception when receiving missing description
 */
public class MissingDescriptionException extends ScribblesException {
    public MissingDescriptionException() {
        super("Error: Your task is missing a description! D:");
    }
}
