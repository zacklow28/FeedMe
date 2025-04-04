package feedme.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void todo() {
        //case 1
        assertEquals("Jan 01 2001",
                new Deadline("deadline return book", "2001-01-01").getDate());
        assertEquals("[D][ ] deadline return book by: 2007-12-03",
                new Deadline("deadline return book", "2007-12-03").toString());
        assertEquals("[D][ ] deadline return book by: Dec 03 2007",
                new Deadline("deadline return book", "2007-12-03").toNewFormat());
    }
}
