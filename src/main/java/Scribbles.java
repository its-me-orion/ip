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

    public void addTask(String desc) {
        taskList.add(new Task(desc));
        echo("I have added the task '%s' for you! :3".formatted(desc));
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
            tokens = userInput.split(" ");

            if (tokens[0].equalsIgnoreCase("bye")) {
                break;
            }

            if (tokens[0].equalsIgnoreCase("list")) {
                scribble.displayList();
                continue;
            }

            if (tokens[0].equalsIgnoreCase("mark")) {
                scribble.markTask(Integer.parseInt(tokens[1]));
                continue;
            }

            if (tokens[0].equalsIgnoreCase("unmark")) {
                scribble.unmarkTask(Integer.parseInt(tokens[1]));
                continue;
            }

            scribble.addTask(userInput);
        }

        System.out.println(Scribbles.EXITMSG);
    }
}
