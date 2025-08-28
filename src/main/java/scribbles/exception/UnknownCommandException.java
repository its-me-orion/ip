package scribbles.exception;

// Error message include the command (unknown) that was being attempted
public class UnknownCommandException extends ScribblesException {
    public UnknownCommandException(String cmd) {
        super("Error: I do not know what you mean by '%s' @.@".formatted(cmd));
    }
}
