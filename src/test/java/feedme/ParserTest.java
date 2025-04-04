package feedme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    public void parseInputToCommand() {
        //case 1
        assertEquals("goodbye", Parser.parseInputToCommand("bye"));
        assertEquals("printlist", Parser.parseInputToCommand("list"));
        assertEquals("mark", Parser.parseInputToCommand("mark 1"));
        assertEquals("unmark", Parser.parseInputToCommand("unmark 1"));
        assertEquals("delete", Parser.parseInputToCommand("delete 1"));
        assertEquals("task", Parser.parseInputToCommand("todo borrow book"));
        assertEquals("task", Parser.parseInputToCommand("deadline return book /by 2007-12-03"));
        assertEquals("task", Parser.parseInputToCommand("event sell book /from 2007-12-03 /to 2007-12-04"));
        assertEquals("invalid", Parser.parseInputToCommand("timeline return book /by 2007-12-03"));
    }

    @Test
    public void parseInputToCommandInt() {
        //case 1
        assertEquals(0, Parser.parseInputToIndex("mark 1"));
        assertEquals(1, Parser.parseInputToIndex("delete 2"));
        assertEquals(32, Parser.parseInputToIndex("unmark 33"));
    }

    @Test
    public void parseInputToCommandTask() {
        //case 1
        assertEquals("[todo, borrow book]", Parser.parseInputToArrayOfTaskParameters("todo borrow book").toString());
        assertEquals("[deadline, return book, 2007-12-03]",
                Parser.parseInputToArrayOfTaskParameters("deadline return book /by 2007-12-03").toString());
        assertEquals("[event, sell book, 2007-12-03, 2007-12-04]",
                Parser.parseInputToArrayOfTaskParameters("event sell book /from 2007-12-03 /to 2007-12-04").toString());
    }
}
