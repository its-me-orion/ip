package scribbles.task;

/**
 * Provides the properties of a to do task.
 */
public class ToDoTask extends Task {
    private static final String LABEL = "T";

    /**
     * Constructs a to do task.
     *
     * @param desc Description of the task.
     */
    public ToDoTask(String desc) {
        super(desc);
    }

    /**
     * Constructs a to do task that is either
     * complete or incomplete.
     *
     * @param desc Description of the task.
     * @param isDone Whether the task is completed or not.
     */
    public ToDoTask(String desc, boolean isDone) {
        super(desc, isDone);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String encode() {
        return "%s | %s".formatted(LABEL, super.encode());
    }

    @Override
    public String toString() {
        return "[%s]%s".formatted(LABEL, super.toString());
    }
}
