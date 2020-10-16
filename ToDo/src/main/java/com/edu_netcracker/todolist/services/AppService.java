package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.impl.IdSimple;
import com.edu_netcracker.todolist.services.impl.JsonFileService;

import java.util.Scanner;

public class AppService {
    IdService idService = new IdSimple();
    ToDoListKeeper keeper = new JsonFileService();
    Scanner scanner = new Scanner(System.in);

//    todo: сделать адекватным интерфейсом

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
            toDoList = keeper.readToDoList();
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
        keeper.writeToDoList(toDoList);
    }
}
