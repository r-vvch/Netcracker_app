package com.edu_netcracker.todo;

import com.edu_netcracker.todo.entities.ToDoList;
import com.edu_netcracker.todo.services.FileService;
import com.edu_netcracker.todo.services.AppService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String command;
        ToDoList toDoList;
        AppService appService = new AppService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the world's finest to-do app!");
        toDoList = appService.start();
        appService.printList();
        System.out.print("> ");

        command = scanner.nextLine();
        while (!command.equals("exit")) {
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "add":
                    appService.addTask(commands[1]);
                    break;
                case "set":
                    if (commands[2].equals("done")) {
                        appService.setTaskDone(Long.parseLong(commands[1]));
                    } else if (commands[2].equals("undone")) {
                        appService.setTaskUndone(Long.parseLong(commands[1]));
                    } else {
                        System.out.println("Bad command, try again");
                        command = scanner.nextLine();
                    }
                    break;
                case "delete":
                    appService.deleteTask(Long.parseLong(commands[1]));
                    break;
                default:
                    System.out.println("Bad command, try again");
            }
            appService.printList();
            System.out.print("> ");
            command = scanner.nextLine();
        }
        System.out.println("Saving to-do list...");
        appService.saveList();

    }

    // проверить работоспособность [v]
    // сделать нормальное id [v]
    // обработать ошибки
    // понять сценарий работы с пользователем [v]
    // реализовать [v]

}
