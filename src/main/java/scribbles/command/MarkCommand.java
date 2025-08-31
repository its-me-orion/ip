package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to mark a specified task as completed.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Constructs a command to mark a specified task as completed.
     *
     * @param index Task index number to mark from taskList.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        try {
            Task task = taskList.markTask(index);
            storage.saveFile(taskList);
            Ui.echo(
                    "Hoorah! I shall mark this task as completed! XD",
                    "  %s".formatted(task.toString())
            );
        } catch (IndexOutOfBoundsException e) {
            throw new ScribblesException("I cannot find this task number :(");
        }
    }
}
