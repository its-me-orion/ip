package scribbles.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import scribbles.task.Task;
import scribbles.tasklist.TaskList;

/**
 * Provides the UI elements and printing of Scribbles
 */
public class Ui {

    public static final String WELCOME_MSG = """
            Heya! I'm Scribbles, your personal task assistant!
            I am made out of scribbles! >w<
            What can I do for you? :)
            """;
    public static final String EXIT_MSG = "Bai bai! See you next time! :D";
    private static final String LINE = "    <----------------------------------------------->";
    private static final String INPUT_PREFIX = "> ";
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Echoes string(s) and encapsulate them
     * between horizontal lines.
     *
     * @param lines String(s) to be echoed.
     */
    public static void echo(String... lines) {
        Ui.echo(Arrays.asList(lines));
    }

    /**
     * Echoes a list of strings and encapsulate them
     * between horizontal lines.
     *
     * @param lines List of strings to be echoed.
     */
    public static void echo(List<String> lines) {
        System.out.println(LINE);
        for (String line : lines) {
            System.out.printf("    %s%n", line);
        }
        System.out.println(LINE);
    }

    /**
     * Reads in user's input.
     *
     * @return User's input in String format.
     */
    public static String readCommand() {
        System.out.print(INPUT_PREFIX);
        return scanner.nextLine();
    }

    /**
     * Prints the welcome message.
     */
    public static void displayWelcomeMsg() {
        System.out.println(Ui.WELCOME_MSG);
    }

    /**
     * Prints the goodbye message.
     */
    public static void displayExitMsg() {
        System.out.println(Ui.EXIT_MSG);
    }

    /**
     * Prints the list of tasks in task list.
     *
     * @param taskList Task list to print the tasks from.
     */
    public static void displayList(TaskList taskList) {
        List<Task> taskListData = taskList.getTaskList();
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < taskListData.size(); i++) {
            tasks.add("%d. %s".formatted(i + 1, taskListData.get(i).toString()));
        }
        Ui.echo(tasks);
    }

    /**
     * Prints the error message received.
     *
     * @param msg The error message to be printed.
     */
    public static void displayError(String msg) {
        Ui.echo(msg);
    }
}
