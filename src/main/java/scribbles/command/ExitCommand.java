package scribbles.command;

import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

/**
 * Provides the command logic to exit Scribbles.
 */
public class ExitCommand extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        storage.saveFile(taskList);
        scribbles.exit();
    }
}
