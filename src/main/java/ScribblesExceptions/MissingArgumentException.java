package ScribblesExceptions;

public class MissingArgumentException extends ScribblesException {
    public MissingArgumentException(String... params) {
        super("Error: You did not provide any arguments for the following parameter(s): %s (._.)"
                .formatted(String.join(", ", params)));
    }
}
