package scribbles.command;

import java.util.ArrayList;
import java.util.List;

import scribbles.Scribbles;
import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the command logic to find tasks based on keyword.
 */
public class FindCommand extends Command {

    private final String findStr;

    /**
     * Constructs a command to find tasks based on keyword.
     *
     * @param findStr String to find in tasks.
     */
    public FindCommand(String findStr) {
        this.findStr = findStr.toLowerCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        List<String> filteredTasks = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getDesc().toLowerCase().contains(this.findStr)) {
                filteredTasks.add("    %s. %s".formatted(filteredTasks.size() + 1, task));
            }
        }
        if (filteredTasks.isEmpty()) {
            Ui.echo("I can't find any task with '%s' in it.. -.-".formatted(this.findStr));
        } else {
            Ui.echo(filteredTasks);
        }
    }
}
