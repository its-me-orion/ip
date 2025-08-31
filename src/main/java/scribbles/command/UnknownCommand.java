package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.exception.UnknownCommandException;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;

/**
 * Provides the command logic when encountering an unknown command.
 */
public class UnknownCommand extends Command {
    private final String cmd;

    /**
     * Constructs a command to throw an UnknownCommandException.
     *
     * @param cmd Unknown command given.
     */
    public UnknownCommand(String cmd) {
        this.cmd = cmd;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        throw new UnknownCommandException(cmd);
    }
}
