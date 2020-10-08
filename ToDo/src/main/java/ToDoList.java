import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private Long id;
    private String name;
    private List<Task> tasks;

    ToDoList() {
        setName("New to-do list");
        setId();
        tasks = new ArrayList<Task>();
    }

    ToDoList(String name) {
        setName(name);
        setId();
        tasks = new ArrayList<Task>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId() {
        this.id = 0L;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
