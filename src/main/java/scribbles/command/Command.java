package scribbles.command;

import scribbles.Scribbles;
import scribbles.exception.ScribblesException;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;

public abstract class Command {

    public abstract void execute(Scribbles scribbles, TaskList taskList, Storage storage) throws ScribblesException;
}
