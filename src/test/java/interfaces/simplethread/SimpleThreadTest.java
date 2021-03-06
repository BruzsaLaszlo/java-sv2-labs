package interfaces.simplethread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SimpleThreadTest {

    @Test
    void runWithEmptyTasks() {
        List<String> tasks = new ArrayList<>();
        SimpleThread simpleThread = new SimpleThread(tasks);
        assertEquals(0, simpleThread.getTasks().size());

        simpleThread.run();

        assertEquals(0, simpleThread.getTasks().size());
    }

    @Test
    void runWithTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sut");
        tasks.add("foz");
        tasks.add("takarit");
        SimpleThread simpleThread = new SimpleThread(tasks);
        assertEquals(tasks.size(), simpleThread.getTasks().size());

        simpleThread.run();

        assertEquals(0, simpleThread.getTasks().size());
    }

}