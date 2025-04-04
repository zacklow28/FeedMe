package feedme.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {
    @Test
    public void todo() {
        //case 1
        assertEquals("[T][ ] todo borrow book", new ToDo("todo borrow book").toString());
        assertEquals("[T][ ] todo borrow book", new ToDo("todo borrow book").toNewFormat());
    }
}
