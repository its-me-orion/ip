import java.util.ArrayList;
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

    public void echo(String cmd) {
        String output = """
                    <----------------------------------------------->
                    %s
                    <----------------------------------------------->
                """.formatted(cmd);
        System.out.println(output);
    }

    public void addTask(String desc) {
        taskList.add(new Task(desc));
        System.out.println("    <----------------------------------------------->");
        System.out.printf("    I have added the task '%s' for you! :3%n", desc);
        System.out.println("    <----------------------------------------------->");
    }

    public void markTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.mark();
        System.out.println("    <----------------------------------------------->");
        System.out.println("    Hoorah! I shall mark this task as completed! XD");
        System.out.printf("    %s%n", task.toString());
        System.out.println("    <----------------------------------------------->");
    }

    public void unmarkTask(int n) {
        Task task = this.taskList.get(n - 1);
        task.unmark();
        System.out.println("    <----------------------------------------------->");
        System.out.println("    Aw man.. I shall unmark this task for you. D:");
        System.out.printf("    %s%n", task.toString());
        System.out.println("    <----------------------------------------------->");
    }

    public void displayList() {
        System.out.println("    <----------------------------------------------->");
        for (int i = 0; i < this.taskList.size(); i++) {
            System.out.printf("    %d. %s%n", i + 1, this.taskList.get(i).toString());
        }
        System.out.println("    <----------------------------------------------->");
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
