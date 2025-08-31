package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to unmark a specified task as completed.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructs a command to unmark a specified task as completed.
     *
     * @param index Task index number to unmark from taskList.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * {@inheritDoc}
     */
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
