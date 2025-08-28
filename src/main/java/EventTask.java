public class EventTask extends Task {
    private final String LABEL = "E";
    private final String from;
    private final String to;

    public EventTask(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public EventTask(String desc, String from, String to, boolean isDone) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    private String getFromTo() {
        return "(from: %s to: %s)".formatted(this.from, this.to);
    }

    @Override
    public String encode() {
        return "%s | %s | %s | %s".formatted(LABEL, super.encode(), this.from, this.to);
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getFromTo());
    }
}
