package scribbles.command;

import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;

/**
 * Provides an abstract class for all types of Commands.
 */
public abstract class Command {

    /**
     * Executes the respective command based on given scribbles,
     * taskList, and storage.
     *
     * @param scribbles Instance of scribbles to operate on.
     * @param taskList Instance of taskList to operate on.
     * @param storage Instance of storage to operate on.
     * @throws ScribblesException When encountering error during execution.
     * @inheritDoc
     */
    public abstract void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException;
}
