package scribbles.command;

import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;

public abstract class Command {

    public abstract void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException;
}
