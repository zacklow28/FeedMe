package feedme.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Event inherits from Task. Have extra attributes startDate and endDate
 */
public class Event extends Task {
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructor
     * @param name name of task
     * @param date date of event in format "MMM dd yyyy /to MMM dd yyyy"
     */
    public Event(String name, String date) {
        super(name);
        this.startDate = LocalDate.parse(date.split(" /to ")[0]);
        this.endDate = LocalDate.parse(date.split(" /to ")[1]);
    }

    /**
     * Constructor
     * @param name name of task
     * @param isDone if task is done
     * @param date date of event in format "MMM dd yyyy /to MMM dd yyyy"
     */
    public Event(String name, boolean isDone, String date) {
        super(name, isDone);
        this.startDate = LocalDate.parse(date.split(" /to ")[0]);
        this.endDate = LocalDate.parse(date.split(" /to ")[1]);
    }

    /**
     * Constructor
     * @param name name of task
     * @param startDate startdate of event in format "yyyy-MM-dd"
     * @param endDate enddate of event in format "yyyy-MM-dd"
     */
    public Event(String name, String startDate, String endDate) {
        super(name);
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    /**
     * Returns start date
     * @return String start date
     */
    public String getStartDate() {
        return this.startDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    /**
     * Sets start date
     * @param startDate start date
     */
    public void setFrom(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    /**
     * Returns end date
     * @return String end date
     */
    public String getEndDate() {
        return this.endDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    /**
     * Sets end date
     * @param endDate end date
     */
    public void setTo(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }

    /**
     *  Returns string in format "[E]name from: YYYY-MM-DD to: YYYY-MM-DD"
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("[E]%s from: %s to: %s", super.toString(), this.startDate, this.endDate);
    }

    /**
     * Returns string in format "[E]name from: MMM dd yyyy to: MMM dd yyyy"
     * @return String representation
     */
    public String toNewFormat() {
        return String.format("[E]%s from: %s to: %s", super.toString(),
                                this.getStartDate(), this.getEndDate());
    }
}
