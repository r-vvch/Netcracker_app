public class Task {
    private Long id;
    private String name;
    private boolean isDone = false;

    public Task() {
        setName("New task");
        setId();
    }

    public Task(String name) {
        setName(name);
        setId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCompletion() {
        return isDone;
    }

    public void setId() {
        this.id = 0L;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompletion(boolean isDone) {
        this.isDone = isDone;
    }

}
