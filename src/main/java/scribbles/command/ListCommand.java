package scribbles.command;

import java.util.ArrayList;
import java.util.List;

import scribbles.storage.Storage;
import scribbles.task.Task;
import scribbles.tasklist.TaskList;
import scribbles.Scribbles;
import scribbles.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(Scribbles scribbles, TaskList taskList, Storage storage) {
        if (taskList.size() == 0) {
            Ui.echo("Your task list is currently empty :3");
            return;
        }

        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            tasks.add("    %s. %s".formatted(i + 1, task));
        }
        Ui.echo(tasks);
    }
}
