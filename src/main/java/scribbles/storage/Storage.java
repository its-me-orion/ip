package scribbles.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import scribbles.exception.ScribblesException;
import scribbles.parser.Parser;
import scribbles.task.DeadlineTask;
import scribbles.task.EventTask;
import scribbles.task.Task;
import scribbles.task.ToDoTask;
import scribbles.tasklist.TaskList;

public class Storage {
    private final String FILE_NAME;
    private final String DIRECTORY;
    private final String FILE_PATH;

    public Storage() {
        this.FILE_NAME = "ScribblesData.txt";
        this.DIRECTORY = "./data/";
        this.FILE_PATH = DIRECTORY + FILE_NAME;
    }

    public Storage(String filename, String dir) {
        this.FILE_NAME = filename;
        this.DIRECTORY = dir;
        this.FILE_PATH = DIRECTORY + FILE_NAME;
    }

    public ArrayList<Task> loadFile() throws ScribblesException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        File file = new File(FILE_PATH);
        File directory = new File(DIRECTORY);

        try {
            if (!directory.exists()) {
                directory.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = decodeTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new ScribblesException("scribbles.Scribbles data not found: " + e.getMessage());
        } catch (IOException e) {
            throw new ScribblesException("Error loading file: " + e.getMessage());
        }

        return tasks;
    }

    public void saveFile(TaskList taskList) {
        List<Task> tasks = taskList.getTaskList();
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task task : tasks) {
                fw.write(task.encode() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private Task decodeTask(String taskData) {
        String[] tokens = taskData.split(" \\| ");
        try {
            String taskType = tokens[0];
            boolean isDone = tokens[1].equals("1");
            String desc = tokens[2];

            switch (taskType) {
            case "T":
                return new ToDoTask(desc, isDone);
            case "D":
                LocalDateTime by = Parser.parseDateTime(tokens[3]);
                return new DeadlineTask(desc, by, isDone);
            case "E":
                LocalDateTime from = Parser.parseDateTime(tokens[3]);
                LocalDateTime to = Parser.parseDateTime(tokens[4]);
                return new EventTask(desc, from, to, isDone);
            default:
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A task data is found to be corrupted from save: " + e.getMessage());
            System.out.println("Skipped loading that task");
            return null;
        } catch (Exception e) {
            System.out.println("Unknown data found: " + e.getMessage());
            return null;
        }
    }
}
