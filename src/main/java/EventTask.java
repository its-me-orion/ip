import java.time.LocalDateTime;

public class EventTask extends Task {
    private final String LABEL = "E";
    private final LocalDateTime from;
    private final LocalDateTime to;

    public EventTask(String desc, String from, String to) {
        super(desc);
        this.from = LocalDateTime.parse(from, INPUT_FORMAT);
        this.to = LocalDateTime.parse(to, INPUT_FORMAT);
    }

    public EventTask(String desc, String from, String to, boolean isDone) {
        super(desc, isDone);
        this.from = LocalDateTime.parse(from, INPUT_FORMAT);
        this.to = LocalDateTime.parse(to, INPUT_FORMAT);
    }

    private String getFromTo() {
        return "(from: %s to: %s)".formatted(this.from.format(PRINT_FORMAT), this.to.format(PRINT_FORMAT));
    }

    @Override
    public String encode() {
        return "%s | %s | %s | %s".formatted(LABEL, super.encode(), this.from.format(INPUT_FORMAT), this.to.format(INPUT_FORMAT));
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getFromTo());
    }
}
