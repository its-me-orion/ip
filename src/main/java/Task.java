public abstract class Task {
    private final String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
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

    @Override
    public String toString() {
        return "%s %s".formatted(getStatusIcon(), this.desc);
    }
}
