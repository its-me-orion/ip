package ScribblesExceptions;

// Error occurs when required params are not fulfilled either missing or wrong name
public class InvalidParamException extends ScribblesException {
    public InvalidParamException(String... params) {
        super("Error: You need to include the following parameter(s) for this command: %s (._.)"
                .formatted(String.join(", ", params)));
    }
}
