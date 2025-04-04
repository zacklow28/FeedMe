package feedme.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Deadline inherits from Task. Has a dueDate
 */
public class Deadline extends Task {
    private LocalDate dueDate;

    /**
     *  Constructor
     * @param name name of task
     * @param dueDate date of task
     */
    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = LocalDate.parse(dueDate);
    }

    /**
     *  Constructor with done
     * @param name name of task
     * @param isDone if task is done
     * @param dueDate date of task
     */
    public Deadline(String name, boolean isDone, String dueDate) {
        super(name, isDone);
        this.dueDate = LocalDate.parse(dueDate);
    }

    /**
     *  Returns the date of the task in the format of "MMM dd yyyy"
     *  @return String date
     */
    public String getDate() {
        return this.dueDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    /**
     *  Sets the date of the task
     *  @param date String date
     */
    public void setBy(String date) {
        this.dueDate = LocalDate.parse(date);
    }

    /**
     *  Returns string in format "[E]name by: YYYY-MM-DD"
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("[D]%s by: %s", super.toString(), this.dueDate);
    }

    /**
     *  Returns string in format "[E]name by: MMM dd yyyy"
     * @return String representation
     */
    //new format
    public String toNewFormat() {
        return String.format("[D]%s by: %s", super.toString(), this.getDate());
    }
}
