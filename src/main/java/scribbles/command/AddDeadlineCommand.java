package scribbles.command;

import java.time.LocalDateTime;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to add a deadline task.
 */
public class AddDeadlineCommand extends Command {
    private final String desc;
    private final LocalDateTime by;

    /**
     * Constructs a command to add a deadline task.
     *
     * @param desc Description of the task to add.
     * @param by Deadline of the task to complete by.
     */
    public AddDeadlineCommand(String desc, LocalDateTime by) {
        this.desc = desc;
        this.by = by;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        taskList.addDeadlineTask(this.desc, this.by);
        Ui.echo("I have added a deadline task '%s' for you! :3".formatted(this.desc));
        storage.saveFile(taskList);
    }
}
