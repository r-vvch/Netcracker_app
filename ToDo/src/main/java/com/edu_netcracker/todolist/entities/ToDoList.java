package com.edu_netcracker.todolist.entities;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private int id;
    private String name;
    private List<Task> tasks;

    public ToDoList() {
        setName("New to-do list");
        tasks = new ArrayList<>();
    }

    public ToDoList(String name) {
        setName(name);
        tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void renameTask(int id, String newName) {
        int i = 0;
        while (true) {
            if (tasks.get(i).getId() == id) {
                tasks.get(i).setName(newName);
                break;
            }
            i++;
        }
    }

}
