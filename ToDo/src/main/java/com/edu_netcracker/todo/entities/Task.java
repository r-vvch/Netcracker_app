package com.edu_netcracker.todo.entities;

public class Task {
    private Long id;
    private String name;
    private boolean isDone = false;

    public Task() {
        setName("New task");
        setCompletion(false);
    }

    public Task(String name) {
        setName(name);
        setCompletion(false);
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

    public String getPrettyCompletion() {
        if (isDone) {
            return "[v]";
        } else {
            return "[ ]";
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompletion(boolean isDone) {
        this.isDone = isDone;
    }

}
