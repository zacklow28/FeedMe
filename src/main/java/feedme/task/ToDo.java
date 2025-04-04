package feedme.task;

/**
 * ToDo inherits from Task. No extra attributes
 */
public class ToDo extends Task {

    /**
     * Constructor
     * @param name The name of the task
     */
    public ToDo(String name) {
        super(name);
    }

    /**
     * Constructor
     * @param name name of task
     * @param isDone if task is done
     */
    public ToDo(String name, boolean isDone) {
        super(name, isDone);
    }

    /**
     * Returns string in format "[T][ ] name"
     * @return String representation
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns string in format "[T][ ] name"
     * @return String representation
     */
    //new format
    public String toNewFormat() {
        return "[T]" + super.toString();
    }
}
