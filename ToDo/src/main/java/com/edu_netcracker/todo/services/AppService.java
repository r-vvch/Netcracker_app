package com.edu_netcracker.todo.services;

import com.edu_netcracker.todo.entities.Task;
import com.edu_netcracker.todo.entities.ToDoList;

import java.util.Scanner;

public class AppService {
    IdService idService = new IdService();
    FileService fs = new FileService();
    Scanner scanner = new Scanner(System.in);

    private ToDoList toDoList;

    public ToDoList start() throws Exception {
        System.out.print("Start a new to-do list? [y/n]\n> ");
        if (scanner.nextLine().equals("y")) {
            toDoList = new ToDoList();
            idService.setListId(toDoList);
            System.out.print("Enter list name: ");
            String listName = scanner.nextLine();
            toDoList.setName(listName);
        } else {
            System.out.println("Loading saved list...");
            toDoList = fs.readToDoList();
            idService.setListId(toDoList);
            for (int i = 0; i < toDoList.getTasks().size(); i++) {
                idService.setTaskId(toDoList.getTasks().get(i));
            }
        }
        return toDoList;
    }

    public void addTask(String name) {
        Task task = new Task(name);
        idService.setTaskId(task);
        toDoList.addTask(task);
    }

    public void deleteTask(Long id) {
        toDoList.deleteTask(id - 1L);
    }

    public void setTaskDone(Long id) {
        toDoList.getTasks().get(id.intValue() - 1).setCompletion(true);
    }

    public void setTaskUndone(Long id) {
        toDoList.getTasks().get(id.intValue() - 1).setCompletion(false);
    }

    public void printList() {
        System.out.println(toDoList.getName() + ":");
        for (int i = 0; i < toDoList.getTasks().size(); i++) {
            System.out.println(toDoList.getTasks().get(i).getId() + ". " +
                    toDoList.getTasks().get(i).getName() + " " + toDoList.getTasks().get(i).getPrettyCompletion());
        }
    }

    public void saveList() throws Exception {
        fs.writeToDoList(toDoList);
    }
}
