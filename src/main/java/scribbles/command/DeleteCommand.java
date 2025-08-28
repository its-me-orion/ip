package scribbles.command;

import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

/**
 * Provides the command logic to delete a specified task.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Constructs a command to delete a specified task.
     *
     * @param index Task index number to delete from taskList.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        try {
            Task task = taskList.deleteTask(index);
            storage.saveFile(taskList);
            Ui.echo (
                    "Orkay! I have banished this task from existence:",
                    "  %s".formatted(task.toString()),
                    "You now have %s task(s) remaining! ^_^".formatted(taskList.size())
            );
        } catch (IndexOutOfBoundsException e) {
            throw new ScribblesException("I cannot find this task number :(");
        }
    }
}
