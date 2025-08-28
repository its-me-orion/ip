public class DeadlineTask extends Task {
    private final String LABEL = "D";
    private final String by;

    public DeadlineTask(String desc, String by) {
        super(desc);
        this.by = by;
    }

    public DeadlineTask(String desc, String by, boolean isDone) {
        super(desc, isDone);
        this.by = by;
    }

    private String getBy() {
        return "(by: %s)".formatted(this.by);
    }

    @Override
    public String encode() {
        return "%s | %s | %s".formatted(LABEL, super.encode(), this.by);
    }

    @Override
    public String toString() {
        return "[%s]%s %s".formatted(LABEL, super.toString(), this.getBy());
    }
}
