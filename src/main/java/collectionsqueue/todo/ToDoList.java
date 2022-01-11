package collectionsqueue.todo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ToDoList {

    private List<ToDo> todos;

    public ToDoList(List<ToDo> todos) {
        this.todos = todos;
    }

    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList(List.of(
                new ToDo("porszívózni", false),
                new ToDo("csekket befizetni", true),
                new ToDo("bevásárolni", false),
                new ToDo("házi feladatot megcsinálni", true)
        ));

        var result = toDoList.getToDosInUrgencyOrder();
        System.out.println(result);
        System.out.println(result.pop());
    }

    public Deque<ToDo> getToDosInUrgencyOrder() {
        var result = new ArrayDeque<ToDo>();
        for (ToDo todo : todos) {
            if (todo.isUrgent()) {
                result.addFirst(todo);
            } else {
                result.addLast(todo);
            }
        }
        return result;
    }
}
