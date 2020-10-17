package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.AppService;
import com.edu_netcracker.todolist.services.IdService;
import com.edu_netcracker.todolist.services.SaveService;

import java.util.Scanner;

public class AppConsole implements AppService {
    IdService idService = new IdSimple();
    SaveService keeper = new SaveJson();
    Scanner scanner = new Scanner(System.in);

    private ToDoList toDoList;
    private Object Exception;

    @Override
    public ToDoList start() throws Exception {
        System.out.print("Start a new to-do list? [y/n]\n> ");
        String input = scanner.nextLine();
        while (!input.equals("y") & !input.equals("n")) {
            System.out.print("It's y or n\n> ");
            input = scanner.nextLine();
        }
        if (input.equals("y")) {
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

    @Override
    public void addTask(String name) {
        Task task = new Task(name);
        idService.setTaskId(task);
        toDoList.addTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        toDoList.deleteTask(id - 1L);
    }

    @Override
    public void setTaskDone(Long id) {
        toDoList.getTasks().get(id.intValue() - 1).setCompletion(true);
    }

    @Override
    public void setTaskUndone(Long id) {
        toDoList.getTasks().get(id.intValue() - 1).setCompletion(false);
    }

    @Override
    public void printList() {
        System.out.println(toDoList.getName() + ":");
        for (int i = 0; i < toDoList.getTasks().size(); i++) {
            System.out.println(toDoList.getTasks().get(i).getId() + ". " +
                    toDoList.getTasks().get(i).getName() + " " + toDoList.getTasks().get(i).getPrettyCompletion());
        }
    }

    @Override
    public void saveList() throws Exception {
        keeper.writeToDoList(toDoList);
    }
}

