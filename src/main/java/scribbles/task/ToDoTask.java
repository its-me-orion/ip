package scribbles.task;

public class ToDoTask extends Task {
    private static final String LABEL = "T";

    public ToDoTask(String desc) {
        super(desc);
    }

    public ToDoTask(String desc, boolean isDone) {
        super(desc, isDone);
    }

    @Override
    public String encode() {
        return "%s | %s".formatted(LABEL, super.encode());
    }

    @Override
    public String toString() {
        return "[%s]%s".formatted(LABEL, super.toString());
    }
}
