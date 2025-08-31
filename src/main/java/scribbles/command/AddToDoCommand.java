package scribbles.command;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to add to do task.
 */
public class AddToDoCommand extends Command {
    private final String desc;

    /**
     * Constructs a command to add a to do task.
     *
     * @param desc Description of the task to add.
     */
    public AddToDoCommand(String desc) {
        this.desc = desc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        taskList.addToDoTask(this.desc);
        Ui.echo("I have added a todo task '%s' for you! :3".formatted(this.desc));
        storage.saveFile(taskList);
    }
}
