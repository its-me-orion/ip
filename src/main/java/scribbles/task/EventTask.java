package scribbles.task;

import java.time.LocalDateTime;

import scribbles.parser.Parser;

public class EventTask extends Task {
    private static final String LABEL = "E";
    private final LocalDateTime from;
    private final LocalDateTime to;

    public EventTask(String desc, LocalDateTime from, LocalDateTime to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public EventTask(String desc, LocalDateTime from, LocalDateTime to, boolean isDone) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    private String getFromTo() {
        return "(from: %s to: %s)".formatted(this.from.format(Parser.PRINT_FORMAT)
                , this.to.format(Parser.PRINT_FORMAT));
    }

    @Override
    public String encode() {
        return "%s | %s | %s | %s".formatted(LABEL, super.encode()
                , this.from.format(Parser.INPUT_FORMAT), this.to.format(Parser.INPUT_FORMAT));
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getFromTo());
    }
}
