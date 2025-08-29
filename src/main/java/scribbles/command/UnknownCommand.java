package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.exception.UnknownCommandException;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;

public class UnknownCommand extends Command {
    private final String cmd;

    public UnknownCommand(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException {
        throw new UnknownCommandException(cmd);
    }
}
