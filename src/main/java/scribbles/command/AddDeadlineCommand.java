package scribbles.command;

import java.time.LocalDateTime;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

public class AddDeadlineCommand extends Command {
    private final String desc;
    private final LocalDateTime by;

    public AddDeadlineCommand(String desc, LocalDateTime by) {
        this.desc = desc;
        this.by = by;
    }

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        taskList.addDeadlineTask(this.desc, this.by);
        Ui.echo("I have added a deadline task '%s' for you! :3".formatted(this.desc));
        storage.saveFile(taskList);
    }
}
