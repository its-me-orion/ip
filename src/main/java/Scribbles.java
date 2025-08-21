import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


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

    public Scribbles() {
        this.taskList = new ArrayList<Task>();
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
    }

    public void addDeadlineTask(String desc, String by) {
        taskList.add(new DeadlineTask(desc, by));
        echo("I have added a deadline task '%s' for you! :3".formatted(desc));
    }

    public void addEventTask(String desc, String from, String to) {
        taskList.add(new EventTask(desc, from, to));
        echo("I have added an event task '%s' for you! :3".formatted(desc));
    }

    public void markTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.mark();
        echo(
      "Hoorah! I shall mark this task as completed! XD",
            "  %s".formatted(task.toString())
        );
    }

    public void unmarkTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.unmark();
        echo(
      "Aw man.. I shall unmark this task for you. D:",
            "  %s".formatted(task.toString())
        );
    }

    public void displayList() {
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            tasks.add("%d. %s".formatted(i + 1, taskList.get(i).toString()));
        }
        echo(tasks);
    }

    public static void main(String[] args) {
        System.out.println(Scribbles.WELCOMEMSG);
        Scribbles scribble = new Scribbles();
        Scanner scanner = new Scanner(System.in);
        String[] tokens = {""};

        while (!tokens[0].equalsIgnoreCase("bye")) {
            System.out.print("> ");
            String userInput = scanner.nextLine();
            tokens = userInput.split(" ", 2);  // Split only first command from the rest

            if (tokens[0].equalsIgnoreCase("bye")) {
                break;
            }

            if (tokens[0].equalsIgnoreCase("list")) {
                scribble.displayList();
                continue;
            }

            // Modify properties of task
            if (tokens[0].equalsIgnoreCase("mark")) {
                scribble.markTask(Integer.parseInt(tokens[1]));
                continue;
            }

            if (tokens[0].equalsIgnoreCase("unmark")) {
                scribble.unmarkTask(Integer.parseInt(tokens[1]));
                continue;
            }

            // Creation of different tasks
            if (tokens[0].equalsIgnoreCase("todo")) {
                scribble.addToDoTask(tokens[1]);
                continue;
            }

            if (tokens[0].equalsIgnoreCase("deadline")) {
                String[] content = tokens[1].split(" /by ", 2);
                // Might be redundant to declare and use the variable immediately
                // but ensures clarity of what content contains
                String desc = content[0];
                String by = content[1];
                scribble.addDeadlineTask(desc, by);
                continue;
            }

            if (tokens[0].equalsIgnoreCase("event")) {
                String[] content = tokens[1].split(" /from ", 2);
                String[] fromTo = content[1].split(" /to ", 2);
                String desc = content[0];
                String from = fromTo[0];
                String to = fromTo[1];
                scribble.addEventTask(desc, from, to);
                continue;
            }

            // Tentatively echo inputs that is not associated with any commands
            scribble.echo(userInput);
        }

        System.out.println(Scribbles.EXITMSG);
    }
}
