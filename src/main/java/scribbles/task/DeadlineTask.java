package scribbles.task;

import java.time.LocalDateTime;

import scribbles.parser.Parser;

public class DeadlineTask extends Task {
    private final String LABEL = "D";
    private final LocalDateTime by;

    public DeadlineTask(String desc, LocalDateTime by) {
        super(desc);
        this.by = by;
    }

    public DeadlineTask(String desc, LocalDateTime by, boolean isDone) {
        super(desc, isDone);
        this.by = by;
    }

    private String getBy() {
        return "(by: %s)".formatted(this.by.format(Parser.PRINT_FORMAT));
    }

    @Override
    public String encode() {
        return "%s | %s | %s".formatted(LABEL, super.encode()
                , this.by.format(Parser.INPUT_FORMAT));
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getBy());
    }
}
