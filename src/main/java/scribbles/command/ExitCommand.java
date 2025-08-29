package scribbles.command;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;

public class ExitCommand extends Command {

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        storage.saveFile(taskList);
        scribbles.exit();
    }
}
