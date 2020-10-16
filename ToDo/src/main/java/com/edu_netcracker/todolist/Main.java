package com.edu_netcracker.todolist;

import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.AppService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;


public class Main {
    static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        LOGGER.info("Hello World!");

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
//                    todo: разобраться, что с двумя словами
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
//                    todo: Обработать, если передаётся название
//                    if (commands[1].matches("[0-9]+")) {
                        appService.deleteTask(Long.parseLong(commands[1]));
                        break;
//                    } else {
//                        System.out.println("Bad command, try again");
//                        command = scanner.nextLine();
//                    }
                default:
                    System.out.println("Bad command, try again");
                    command = scanner.nextLine();
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
