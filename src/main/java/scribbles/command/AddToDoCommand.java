package scribbles.command;

import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

public class AddToDoCommand extends Command {
    private final String desc;

    public AddToDoCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        taskList.addToDoTask(this.desc);
        Ui.echo("I have added a todo task '%s' for you! :3".formatted(this.desc));
        storage.saveFile(taskList);
    }
}
