package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to delete a specified task.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a command to delete a specified task.
     *
     * @param taskIndex Task taskIndex number to delete from taskList.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        try {
            Task task = taskList.deleteTask(taskIndex);
            storage.saveFile(taskList);
            Ui.echo(
                    "Orkay! I have banished this task from existence:",
                    "  %s".formatted(task.toString()),
                    "You now have %s task(s) remaining! ^_^".formatted(taskList.size())
            );
        } catch (IndexOutOfBoundsException e) {
            throw new ScribblesException("I cannot find this task number :(");
        }
    }
}
