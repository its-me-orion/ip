package scribbles.tasklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import scribbles.task.DeadlineTask;
import scribbles.task.EventTask;
import scribbles.task.Task;
import scribbles.task.ToDoTask;

/**
 * Provides a class that handles a list of tasks.
 */
public class TaskList {
    private List<Task> taskList;

    /**
     * Constructs an empty list of tasks.
     */
    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    /**
     * Constructs a pre-existing list of tasks.
     *
     * @param taskList taskList data to use.
     */
    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Adds a to do task into the task list.
     *
     * @param desc Description of the task.
     */
    public void addToDoTask(String desc) {
        taskList.add(new ToDoTask(desc));
    }

    /**
     * Adds a deadline task into the task list.
     *
     * @param desc Description of the task.
     * @param by Deadline of the task to complete by.
     */
    public void addDeadlineTask(String desc, LocalDateTime by) {
        taskList.add(new DeadlineTask(desc, by));
    }

    /**
     * Adds an event task into the task list.
     *
     * @param desc Description of the task.
     * @param from Event dateTime of the task starting from.
     * @param to Event dateTime of the task ending to.
     */
    public void addEventTask(String desc, LocalDateTime from, LocalDateTime to) {
        taskList.add(new EventTask(desc, from, to));
    }

    /**
     * Marks a task as completed based on it's index
     * in the task list.
     *
     * @param n Index of task in task list to mark.
     * @return Task that was marked.
     */
    public Task markTask(int n) {
        Task task = this.taskList.get(n);
        task.mark();
        return task;
    }

    /**
     * Unmarks a task as completed based on it's index
     * in the task list.
     *
     * @param n Index of task in task list to unmark.
     * @return Task that was unmarked.
     */
    public Task unmarkTask(int n) {
        Task task = this.taskList.get(n);
        task.unmark();
        return task;
    }

    /**
     * Deletes a task as completed based on it's index
     * in the task list.
     *
     * @param n Index of task in task list to delete.
     * @return Task that was deleted.
     */
    public Task deleteTask(int n) {
        Task task = this.taskList.get(n);
        this.taskList.remove(n);
        return task;
    }

    /**
     * Retrieves the task based on it's index
     * in the task list.
     *
     * @param n Index of task in task list to retrieve.
     * @return Task to be retrieved.
     */
    public Task get(int n) {
        return this.taskList.get(n);
    }

    /**
     * Retrieves the number of tasks in the task list.
     *
     * @return Number of tasks in task list.
     */
    public int size() {
        return this.taskList.size();
    }
}
