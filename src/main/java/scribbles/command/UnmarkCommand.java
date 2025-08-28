package scribbles.command;

import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        try {
            Task task = taskList.unmarkTask(index);
            storage.saveFile(taskList);
            Ui.echo(
                    "Aw man.. I shall unmark this task for you. D:",
                    "  %s".formatted(task.toString())
            );
        } catch (IndexOutOfBoundsException e) {
            throw new ScribblesException("I cannot find this task number :(");
        }
    }
}
