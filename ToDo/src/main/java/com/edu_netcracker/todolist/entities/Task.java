package com.edu_netcracker.todolist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Task {
    private int id;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCompletion() {
        return isDone;
    }

    @JsonIgnore
    public String getPrettyCompletion() {
        if (isDone) {
            return "[v]";
        } else {
            return "[ ]";
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompletion(boolean isDone) {
        this.isDone = isDone;
    }

}
