package scribbles.tasklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import scribbles.task.DeadlineTask;
import scribbles.task.EventTask;
import scribbles.task.Task;
import scribbles.task.ToDoTask;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }

    public void addToDoTask(String desc) {
        taskList.add(new ToDoTask(desc));
    }

    public void addDeadlineTask(String desc, LocalDateTime by) {
        taskList.add(new DeadlineTask(desc, by));
    }

    public void addEventTask(String desc, LocalDateTime from, LocalDateTime to) {
        taskList.add(new EventTask(desc, from, to));
    }

    public Task markTask(int n) {
        Task task = this.taskList.get(n);
        task.mark();
        return task;
    }

    public Task unmarkTask(int n) {
        Task task = this.taskList.get(n);
        task.unmark();
        return task;
    }

    public Task deleteTask(int n) {
        Task task = this.taskList.get(n);
        this.taskList.remove(n);
        return task;
    }

    public Task get(int n) {
        return this.taskList.get(n);
    }

    public int size() {
        return this.taskList.size();
    }
}
