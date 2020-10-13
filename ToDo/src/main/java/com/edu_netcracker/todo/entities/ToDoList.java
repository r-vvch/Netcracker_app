package com.edu_netcracker.todo.entities;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private Long id;
    private String name;
    private List<Task> tasks;

    public ToDoList() {
        setName("New to-do list");
        tasks = new ArrayList<Task>();
    }

    public ToDoList(String name) {
        setName(name);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Long id) {
        tasks.remove(id.intValue());
    }

    public void printList() {
        System.out.println(getName() + ":");
        for (int i = 0; i < getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + getTasks().get(i).getName() + " " + getTasks().get(i).getPrettyCompletion());
        }
    }

    public void printIdList() {
        System.out.println(getId() + ". " + getName() + ":");
        for (int i = 0; i < getTasks().size(); i++) {
            System.out.println(getTasks().get(i).getId() + ". " + getTasks().get(i).getName() + " " + getTasks().get(i).getPrettyCompletion());
        }
    }

}
