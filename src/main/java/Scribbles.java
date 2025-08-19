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
        String command = "";

        while (!command.equalsIgnoreCase("bye")) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("bye")) {
                break;
            }

            if (command.equalsIgnoreCase("list")) {
                scribble.displayList();
                continue;
            }

            scribble.addTask(command);
        }

        System.out.println(Scribbles.EXITMSG);

    }
}
