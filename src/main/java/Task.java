import java.time.format.DateTimeFormatter;

public abstract class Task {
    public static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    public static final DateTimeFormatter PRINT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");
    private final String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
    }

    public String getDesc() {
        return this.desc;
    }

    // Reused and inspired from Partial Solution provided for Level-3 requirements
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");  // mark done task with X
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String encode() {
        return "%s | %s".formatted((isDone ? "1" : "0"), this.desc);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(getStatusIcon(), this.desc);
    }
}
