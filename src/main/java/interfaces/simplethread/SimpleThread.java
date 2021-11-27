package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable {

    private final List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    private boolean nextStep() {
        if (!tasks.isEmpty())
            tasks.remove(tasks.size() - 1);
        return !tasks.isEmpty();
    }

    public List<String> getTasks() {
        return List.copyOf(tasks);
    }

    @Override
    public void run() {
        while (nextStep()) ;
    }
}
