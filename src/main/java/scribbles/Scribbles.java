package scribbles;

import scribbles.command.Command;
import scribbles.exception.ScribblesException;
import scribbles.parser.Parser;
import scribbles.storage.Storage;
import scribbles.tasklist.TaskList;
import scribbles.ui.Ui;

/**
 * Provides the main entry to run and exit Scribbles
 */
public class Scribbles {

    private Storage storage;
    private TaskList taskList;
    private boolean isRunning = false;

    /**
     * Initialises the storage and task list of Scribbles.
     */
    public Scribbles() {
        this.storage = new Storage();
        try {
            this.taskList = new TaskList(storage.loadFile());
        } catch (ScribblesException e) {
            Ui.displayError(e.getMessage());
            this.taskList = new TaskList();
        }
    }

    /**
     * Stops Scribbles from running during run().
     */
    public void exit() {
        this.isRunning = false;
    }

    /**
     * Runs the main logic flow for Scribbles.
     */
    public void run() {
        this.isRunning = true;
        Ui.displayWelcomeMsg();
        while (isRunning) {
            try {
                String command = Ui.readCommand();
                Command c = Parser.parseCommand(command);
                c.execute(this, this.taskList, this.storage);
            } catch (ScribblesException e) {
                Ui.displayError(e.getMessage());
            }
        }
        Ui.displayExitMsg();
    }
    public static void main(String[] args) {
        new Scribbles().run();
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parseCommand(input);
            return c.execute(this, this.taskList, this.storage);
        } catch (ScribblesException e) {
            return e.getMessage();
        }
    }
}
