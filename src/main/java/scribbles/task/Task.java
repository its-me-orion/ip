package scribbles.task;

/**
 * Provides an abstract class for all types of Tasks.
 */
public abstract class Task {
    private final String desc;
    private boolean isDone;

    /**
     * Constructs an incomplete task with description.
     *
     * @param desc Description of the task.
     */
    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    /**
     * Constructs a task with description that is either
     * complete or incomplete.
     *
     * @param desc Description of the task.
     * @param isDone Whether the task is completed or not.
     */
    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
    }

    public String getDesc() {
        return this.desc;
    }

    // Reused and inspired from Partial Solution provided for Level-3 requirements
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    /**
     * Marks the task as completed.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Marks the task as incomplete.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Encodes the task for saving purposes.
     */
    public String encode() {
        return "%s | %s".formatted((isDone ? "1" : "0"), this.desc);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(getStatusIcon(), this.desc);
    }
}
