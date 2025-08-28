package scribbles.exception;

// Error occurs when required params are not fulfilled either missing or wrong name
public class InvalidDateTimeException extends ScribblesException {
    public InvalidDateTimeException() {
        super("Whoops! Invalid date/time format. Use d/M/yyyy HHmm (e.g. 28/12/2025 1800)");
    }
}
