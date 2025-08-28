package scribbles.ui;

// Utils
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Exceptions
import scribbles.exception.InvalidParamException;
import scribbles.exception.MissingArgumentException;
import scribbles.exception.MissingDescriptionException;
import scribbles.exception.ScribblesException;
import scribbles.exception.UnknownCommandException;
import scribbles.storage.Storage;
import scribbles.task.DeadlineTask;
import scribbles.task.EventTask;
import scribbles.task.Task;
import scribbles.task.ToDoTask;


public class Scribbles {

    public static final String WELCOMEMSG = """
            .----------------------------------------------------.
            | Heya! I'm Scribbles, your personal task assistant! |
            | What can I do for you? :)                          |
            '----------------------------------------------------'
            """;
    public static final String EXITMSG = """
            .----------------------------------------------------.
            | Bai bai! See you next time! :D                     |
            '----------------------------------------------------'
            """;

    private List<Task> taskList;
    private Storage storage;

    public Scribbles() {
        this.storage = new Storage();
        this.taskList = storage.loadFile();
    }

    // Overloaded - accepts single or multiple string args (does not require list conversion as it is done here)
    private void echo(String... lines) {
        echo(Arrays.asList(lines));
    }

    private void echo(List<String> lines) {
        System.out.println("    <----------------------------------------------->");
        for (String line : lines) {
            System.out.printf("    %s%n", line);
        }
        System.out.println("    <----------------------------------------------->");
    }

    /*
     * Maybe there is a way to utilise method overloading instead, but in the event
     * there are tasks with same method signature it becomes problematic.
     * Tasks that share the same method signature would require logic to differentiate
     * within the method itself as well
     */
    public void addToDoTask(String desc) {
        taskList.add(new ToDoTask(desc));
        echo("I have added a todo task '%s' for you! :3".formatted(desc));
        this.saveData();
    }

    public void addDeadlineTask(String desc, String by) {
        taskList.add(new DeadlineTask(desc, by));
        echo("I have added a deadline task '%s' for you! :3".formatted(desc));
        this.saveData();
    }

    public void addEventTask(String desc, String from, String to) {
        taskList.add(new EventTask(desc, from, to));
        echo("I have added an event task '%s' for you! :3".formatted(desc));
        this.saveData();
    }

    public void markTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.mark();
        echo(
      "Hoorah! I shall mark this task as completed! XD",
            "  %s".formatted(task.toString())
        );
        this.saveData();
    }

    public void unmarkTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.unmark();
        echo(
      "Aw man.. I shall unmark this task for you. D:",
            "  %s".formatted(task.toString())
        );
        this.saveData();
    }

    public void deleteTask(int n) {
        Task task = this.taskList.get(n - 1);
        this.taskList.remove(n - 1);
        echo (
      "Orkay! I have banished this task from existence:",
            "  %s".formatted(task.toString()),
            "You now have %s task(s) remaining! ^_^".formatted(this.taskList.size())
        );
        this.saveData();
    }

    public void saveData() {
        this.storage.saveFile(this.taskList);
    }

    public void displayList() {
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            tasks.add("%d. %s".formatted(i + 1, taskList.get(i).toString()));
        }
        echo(tasks);
    }

    public void displayError(String msg) {
        echo(msg);
    }

    public static void main(String[] args) {
        System.out.println(Scribbles.WELCOMEMSG);
        Scribbles scribble = new Scribbles();
        Scanner scanner = new Scanner(System.in);
        String[] tokens = {""};

        while (!tokens[0].equalsIgnoreCase("bye")) {
            System.out.print("> ");
            String userInput = scanner.nextLine();
            try {
                tokens = userInput.split(" ", 2);  // Split only first command from the rest

                if (tokens[0].equalsIgnoreCase("bye")) {
                    scribble.saveData();
                    break;
                }

                if (tokens[0].equalsIgnoreCase("list")) {
                    scribble.displayList();
                    continue;
                }

                // Modify properties of taskList
                if (tokens[0].equalsIgnoreCase("mark")) {
                    scribble.markTask(Integer.parseInt(tokens[1]));
                    continue;
                }

                if (tokens[0].equalsIgnoreCase("unmark")) {
                    scribble.unmarkTask(Integer.parseInt(tokens[1]));
                    continue;
                }

                if (tokens[0].equalsIgnoreCase("delete")) {
                    scribble.deleteTask(Integer.parseInt(tokens[1]));
                    continue;
                }

                // Creation of different tasks
                if (tokens[0].equalsIgnoreCase("todo")) {
                    if (tokens.length == 1 || tokens[1].trim().isEmpty()) {
                        throw new MissingDescriptionException();
                    }
                    scribble.addToDoTask(tokens[1]);
                    continue;
                }

                if (tokens[0].equalsIgnoreCase("deadline")) {
                    // Messy exception handling at the moment and some exception handling are duplicated
                    if (tokens.length == 1 || tokens[1].trim().isEmpty()) {
                        throw new MissingDescriptionException();
                    }
                    if (!tokens[1].contains(" /by ")) {
                        throw new InvalidParamException("/by");
                    }

                    String[] content = tokens[1].split(" /by ", 2);
                    if (content.length == 1 || content[1].trim().isEmpty()) {
                        throw new MissingArgumentException("/by");
                    }
                    // Might be redundant to declare and use the variable immediately
                    // but ensures clarity of what content contains
                    String desc = content[0];
                    String by = content[1];
                    LocalDateTime.parse(by, Task.INPUT_FORMAT);
                    scribble.addDeadlineTask(desc, by);
                    continue;
                }

                if (tokens[0].equalsIgnoreCase("event")) {
                    if (tokens.length == 1 || tokens[1].trim().isEmpty()) {
                        throw new MissingDescriptionException();
                    }

                    List<String> missingParams = new ArrayList<>();
                    if (!tokens[1].contains(" /from ")) {
                        missingParams.add("/from");
                    }
                    if (!tokens[1].contains(" /to ")) {
                        missingParams.add("/to");
                    }
                    if (!missingParams.isEmpty()) {
                        throw new InvalidParamException(String.join(", ", missingParams));
                    }

                    String[] content = tokens[1].split(" /from ", 2);
                    if (content.length == 1 || content[1].trim().isEmpty() || content[1].trim().startsWith("/to")) {
                        throw new MissingArgumentException("/from");
                    }

                    String[] fromTo = content[1].split(" /to ", 2);
                    if (fromTo.length == 1 || fromTo[1].trim().isEmpty()) {
                        throw new MissingArgumentException("/to");
                    }

                    String desc = content[0];
                    String from = fromTo[0];
                    String to = fromTo[1];
                    LocalDateTime.parse(from, Task.INPUT_FORMAT);
                    LocalDateTime.parse(to, Task.INPUT_FORMAT);
                    scribble.addEventTask(desc, from, to);
                    continue;
                }

                throw new UnknownCommandException(userInput);

            } catch (DateTimeParseException e) {
                scribble.displayError("Invalid datetime format :(, please use d/M/yyyy HHmm format");
            } catch (ScribblesException e) {
                scribble.displayError(e.getMessage());
            }
        }

        System.out.println(Scribbles.EXITMSG);
    }
}
