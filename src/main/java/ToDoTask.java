public class ToDoTask extends Task {
    private final String LABEL = "[T]";

    public ToDoTask(String desc) {
        super(desc);
    }

    @Override
    public String toString() {
        return "%s%s".formatted(LABEL, super.toString());
    }
}
