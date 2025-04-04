package feedme.task;

/**
 * Class for tasks
 */
public class Task {
    private String name;
    private Boolean isDone = false;

    /**
     * Constructor
     * @param name name of task
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Constructor
     * @param name name of task
     * @param isDone if task is done
     */
    public Task(String name, Boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * Marks the task. Sets done to true
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks the task. Sets done to false
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Returns name of task
     * @return String name of task
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name of task to a new name
     * @param name name of task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns task in format "[ ] name"
     * @return String representation
     */
    @Override
    public String toString() {
        String checkbox = this.isDone ? "[X] " : "[ ] ";
        return checkbox + name;
    }

    /**
     * Returns task in format "[ ] name"
     * @return String representation
     */
    public String toNewFormat() {
        String checkbox = this.isDone ? "[X] " : "[ ] ";
        return checkbox + name;
    }
}
