package feedme;

import java.util.ArrayList;

/**
 * Parser class that deals with making sense of the user command
 */
public class Parser {

    /**
     * Parses user input into a command
     * @param in user input
     * @return String command
     */
    public static String parseInputToCommand(String in) {
        String[] inArr = in.split(" ", 2); //split just on the first space
        if (in.equals("bye")) {
            return "goodbye";
        } else if (in.equals("list")) {
            return "list";
        } else if (inArr[0].equals("mark")) {
            return "mark";
        } else if (inArr[0].equals("unmark")) {
            return "unmark";
        } else if (inArr[0].equals("delete")) {
            return "delete";
        } else if (inArr[0].equals("todo")) {
            return "task";
        } else if (inArr[0].equals("deadline")) {
            return "task";
        } else if (inArr[0].equals("event")) {
            return "task";
        } else if (inArr[0].equals("find")) {
            return "find";
        } else if (inArr[0].equals("edit")) {
            return "edit";
        } else {
            return "invalid";
        }
    }

    /**
     * Parses user input that includes the index into index of the list
     * @param in user input
     * @return int index
     */
    public static int parseInputToIndex(String in) {
        String[] inArr = in.split(" ", 2); //split just on the first space
        int inputNumber = Integer.parseInt(inArr[1]);
        return inputNumber - 1; //index starts from 0
    }

    /**
     * Parses user input that includes a type of task into an array list
     * @param in user input
     * @return ArrayList of strings, each string is a part of the task. [0] is type of task, [1] is the name etc.
     */
    public static ArrayList<String> parseInputToArrayOfTaskParameters(String in) {
        String[] inArr = in.strip().split(" ", 2);
        ArrayList<String> outArr = new ArrayList<String>();

        assert inArr.length == 2 : "Invalid input!";
        //assumption that the input is a valid task input
        assert inArr[0].equals("todo") || inArr[0].equals("deadline") || inArr[0].equals("event") : "Invalid input!";
        String type = inArr[0];
        outArr.add(type);
        if (type.equals("todo")) {
            outArr.add(inArr[1]);
        } else if (type.equals("deadline")) {
            String[] inArrSplitDeadline = inArr[1].split(" /by ");
            outArr.add(inArrSplitDeadline[0]);
            outArr.add(inArrSplitDeadline[1]);
        } else if (type.equals("event")) {
            String[] inArrSplitEventFrom = inArr[1].split(" /from ");
            outArr.add(inArrSplitEventFrom[0]);

            String[] inArrSplitEventFromTo = inArrSplitEventFrom[1].split(" /to ");
            outArr.add(inArrSplitEventFromTo[0]);
            outArr.add(inArrSplitEventFromTo[1]);
        }
        return outArr;
    }
}
