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

    public void echo(String cmd) {
        String output = """
                    <----------------------------------------------->
                    %s
                    <----------------------------------------------->
                """.formatted(cmd);
        System.out.println(output);
    }

    public static void main(String[] args) {
        System.out.println(Scribbles.WELCOMEMSG);
        Scribbles scribble = new Scribbles();
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("bye")) {
            scribble.echo(command);
            System.out.print("> ");
            command = scanner.nextLine();
        }

        System.out.println(Scribbles.EXITMSG);

    }
}
