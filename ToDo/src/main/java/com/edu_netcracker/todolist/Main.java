package com.edu_netcracker.todolist;

import com.edu_netcracker.todolist.services.AppService;
import com.edu_netcracker.todolist.services.impl.AppConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;


public class Main {
    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        String command;
        AppService appService = new AppConsole();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the world's finest to-do app!");
        appService.start();
        appService.printList();
        System.out.print("> ");

        command = scanner.nextLine();
        while (!command.equals("exit")) {
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "add":
                    StringBuilder buf = new StringBuilder(commands[1]);
                    for (int i = 2; i < commands.length; i++) {
                        buf.append(" ").append(commands[i]);
                    }
                    appService.addTask(buf.toString());
                    break;

                case "set":
                    if (commands[2].equals("done")) {
                        appService.setTaskDone(Long.parseLong(commands[1]));
                    } else if (commands[2].equals("undone")) {
                        appService.setTaskUndone(Long.parseLong(commands[1]));
                    } else {
                        System.out.println("Bad command, try again");
                    }
                    break;

                case "delete":
                    if (!commands[1].matches("[0-9]+")) {
                        System.out.println("Bad command, try again");
                    } else {
                        appService.deleteTask(Long.parseLong(commands[1]));
                    }
                    break;

                default:
                    System.out.print("Bad command, try again\n> ");
                    break;
            }
            appService.printList();
            System.out.print("> ");
            command = scanner.nextLine();
        }
        System.out.println("Saving to-do list...");
        appService.saveList();

        LOGGER.info("Yeah, usual log");

    }

}
