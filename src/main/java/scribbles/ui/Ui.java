package scribbles.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import scribbles.task.Task;
import scribbles.tasklist.TaskList;

public class Ui {

    private static final String WELCOME_MSG = """
            .----------------------------------------------------.
            | Heya! I'm Scribbles, your personal task assistant! |
            | What can I do for you? :)                          |
            '----------------------------------------------------'
            """;
    private static final String EXIT_MSG = """
            .----------------------------------------------------.
            | Bai bai! See you next time! :D                     |
            '----------------------------------------------------'
            """;
    private static final String LINE = "    <----------------------------------------------->";
    private static final String INPUT_PREFIX = "> ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void echo(String... lines) {
        Ui.echo(Arrays.asList(lines));
    }

    public static void echo(List<String> lines) {
        System.out.println(LINE);
        for (String line : lines) {
            System.out.printf("    %s%n", line);
        }
        System.out.println(LINE);
    }

    public static String readCommand() {
        System.out.print(INPUT_PREFIX);
        return scanner.nextLine();
    }

    public static void displayWelcomeMsg() {
        System.out.println(Ui.WELCOME_MSG);
    }

    public static void displayExitMsg() {
        System.out.println(Ui.EXIT_MSG);
    }

    public static void displayList(TaskList taskList) {
        List<Task> taskListData = taskList.getTaskList();
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < taskListData.size(); i++) {
            tasks.add("%d. %s".formatted(i + 1, taskListData.get(i).toString()));
        }
        Ui.echo(tasks);
    }

    public static void displayError(String msg) {
        Ui.echo(msg);
    }
}
