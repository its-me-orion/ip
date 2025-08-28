package scribbles.task;

import java.time.LocalDateTime;

public class DeadlineTask extends Task {
    private final String LABEL = "D";
    private final LocalDateTime by;

    public DeadlineTask(String desc, String by) {
        super(desc);
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }

    public DeadlineTask(String desc, String by, boolean isDone) {
        super(desc, isDone);
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }

    private String getBy() {
        return "(by: %s)".formatted(this.by.format(PRINT_FORMAT));
    }

    @Override
    public String encode() {
        return "%s | %s | %s".formatted(LABEL, super.encode(), this.by.format(INPUT_FORMAT));
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getBy());
    }
}
