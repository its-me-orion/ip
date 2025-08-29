package scribbles.command;

import java.time.LocalDateTime;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

public class AddEventCommand extends Command {
    private final String desc;
    private final LocalDateTime from;
    private final LocalDateTime to;


    public AddEventCommand(String desc, LocalDateTime from, LocalDateTime to) {
        this.desc = desc;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        taskList.addEventTask(this.desc, this.from, this.to);
        Ui.echo("I have added an event task '%s' for you! :3".formatted(this.desc));
        storage.saveFile(taskList);
    }
}
