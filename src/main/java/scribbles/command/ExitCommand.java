package scribbles.command;

import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        storage.saveFile(taskList);
        scribbles.exit();
    }
}
