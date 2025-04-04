package feedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import feedme.task.Deadline;
import feedme.task.Event;
import feedme.task.Task;
import feedme.task.TaskList;
import feedme.task.ToDo;

/**
 * Storage class that deals with loading tasks from the file and saving tasks in the file
 */
public class Storage {
    private String filePath;

    /**
     * Initializes a new tummy. Creates a new file if it doesn't exist
     * @param filePath The path of the file
     * @throws IOException if the file cannot be created
     */
    public String initialize(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                return "Created a new tummy at: " + filePath;
            }
            this.filePath = filePath;
            return "found";
        } catch (IOException e) {
            return "Invalid input! Feed me again!";
        }
    }

    /**
     * Retrieves tasks from a file
     * @param taskList The taskList to add tasks to
     * @param filePath The path of the file
     * @throws IOException if the file cannot be read
     */
    public void retrieveFrom(TaskList taskList, String filePath) throws IOException {
        File file = new File(filePath);
        this.filePath = filePath;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String lineInFile = scanner.nextLine();
            lineInFile = lineInFile.replace("to:", "/to");
            char taskType = lineInFile.charAt(1);
            String food = lineInFile.substring(7).trim(); //exclude the [ ][ ]
            switch (taskType) {
            case 'T':
                if (lineInFile.contains("[X]")) {
                    taskList.addTask(new ToDo(food, true));
                } else {
                    taskList.addTask(new ToDo(food));
                }
                break;
            case 'D':
                String[] foodArr = food.split(" by: ");
                if (lineInFile.contains("[X]")) {
                    taskList.addTask(new Deadline(foodArr[0], true, foodArr[1]));
                } else {
                    taskList.addTask(new Deadline(foodArr[0], foodArr[1]));
                }
                break;
            case 'E':
                String[] foodArr2 = food.split(" from: ");
                if (lineInFile.contains("[X]")) {
                    taskList.addTask(new Event(foodArr2[0], true, foodArr2[1]));
                } else {
                    taskList.addTask(new Event(foodArr2[0], foodArr2[1]));
                }
                break;
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        scanner.close();
    }

    /**
     * Sets the tummy. Reads from a file and either retrieves past tasks or creates a new tummy for the user
     * @param taskList The taskList to add tasks to
     * @param string The path of the file
     * @throws IOException if the file cannot be read
     */
    public String setUsingString(TaskList taskList, String string) throws IOException {
        //read from file
        if (string != null) {
            try {
                this.retrieveFrom(taskList, string);
            } catch (FileNotFoundException e) {
                String output = "Tummy location not found.";
                String init = this.initialize(string);
                if (!init.equals("found")) {
                    return output + "\n" + init;
                }
            } catch (IndexOutOfBoundsException e) {
                return "Invalid/Missing content! Feed me again!";
            } catch (DateTimeParseException e) {
                return "Invalid/Missing Date! Feed me again!";
            } catch (IOException e) {
                return "Invalid input! Feed me again!";
            }

        }
        return "Tummy set!";
    }

    /**
     * Appends a task to the tummy. Writes to the end of the file
     * @param task The task to append
     * @throws IOException if the file cannot be written to
     */
    public void append(Task task) throws IOException {
        FileWriter fw = new FileWriter(this.filePath, true);
        fw.write(task.toString() + "\n");
        fw.close();
    }

    /**
     * Writes the taskList to the tummy. Overwrites the file
     * @param taskList The taskList to write
     * @throws IOException if the file cannot be written to
     */
    public void write(TaskList taskList) throws IOException {
        FileWriter fw = new FileWriter(this.filePath);
        for (Task t : taskList.getListOfTasks()) {
            fw.write(t.toString() + "\n");
        }
        fw.close();
    }
}
