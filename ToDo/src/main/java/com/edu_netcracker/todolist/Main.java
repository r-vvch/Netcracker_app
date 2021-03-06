package com.edu_netcracker.todolist;

import com.edu_netcracker.todolist.services.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        String command;
        AppService appService = context.getBean(AppService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the world's finest to-do app!");
        appService.start();
        System.out.print("> ");
        LOGGER.info("Successful start");

        command = scanner.nextLine();
        while (!command.equals("exit")) {
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "add":
                    // добавление списка задач
                    StringBuilder buf = new StringBuilder(commands[1]);
                    for (int i = 2; i < commands.length; i++) {
                        buf.append(" ").append(commands[i]);
                    }
                    appService.addToDoList(buf.toString());
                    LOGGER.info("To-do list added");
                    break;

                case "delete":
                    // удаляем конкретный список задач
                    if (!commands[1].matches("-[0-9]+")) {
                        System.out.print("Bad command, try again\n");
                        LOGGER.info("Bad command");
                    } else {
                        appService.deleteToDoList(Integer.parseInt(commands[1]));
                        LOGGER.info("To-do list deleted");
                    }
                    break;

                case "rename":
                    // переименовываем конкретный список задач
                    if (!commands[1].matches("-[0-9]+")) {
                        System.out.print("Bad command, try again\n");
                        LOGGER.info("Bad command");
                    } else {
                        appService.renameToDoList(Integer.parseInt(commands[1]), commands[2]);
                        LOGGER.info("To-do list renamed");
                    }
                    break;

                case "select":
                    // выбираем конкретный список задач, оперируем с ним
                    if (!commands[1].matches("-[0-9]+")) {
                        System.out.println("Bad command, try again");
                    } else {
                        appService.setCurrentToDoList(Integer.parseInt(commands[1]));
                        appService.printCurrentToDoList();
                        System.out.print("> ");
                        LOGGER.info("Successful start");

                        String commandCurrentList = scanner.nextLine();
                        while (!commandCurrentList.equals("back")) {
                            String[] commandsCurrentList = commandCurrentList.split(" ");
                            switch (commandsCurrentList[0]) {
                                case "add":
                                    StringBuilder bufList = new StringBuilder(commandsCurrentList[1]);
                                    for (int i = 2; i < commandsCurrentList.length; i++) {
                                        bufList.append(" ").append(commandsCurrentList[i]);
                                    }
                                    appService.addTask(bufList.toString());
                                    LOGGER.info("Task added");
                                    break;

                                case "set":
                                    if (!commandsCurrentList[1].matches("[0-9]+")) {
                                        System.out.println("Bad command, try again");
                                    } else if (commandsCurrentList[2].equals("done")) {
                                        appService.setTaskDone(Integer.parseInt(commandsCurrentList[1]));
                                    } else if (commandsCurrentList[2].equals("undone")) {
                                        appService.setTaskUndone(Integer.parseInt(commandsCurrentList[1]));
                                    } else {
                                        System.out.println("Bad command, try again");
                                    }
                                    LOGGER.info("Task completion set");
                                    break;

                                case "delete":
                                    if (!commandsCurrentList[1].matches("[0-9]+")) {
                                        System.out.println("Bad command, try again");
                                    } else {
                                        appService.deleteTask(Integer.parseInt(commandsCurrentList[1]));
                                        LOGGER.info("Task deleted");
                                    }
                                    break;

                                case "rename":
                                    if (!commandsCurrentList[1].matches("[0-9]+")) {
                                        System.out.println("Bad command, try again");
                                    } else {
                                        appService.renameTask(Integer.parseInt(commandsCurrentList[1]),
                                                commandsCurrentList[2]);
                                        LOGGER.info("Task renamed");
                                    }

                                default:
                                    System.out.print("Bad command, try again\n> ");
                                    LOGGER.info("Bad command");
                                    break;
                            }
                            appService.printCurrentToDoList();
                            System.out.print("> ");
                            commandCurrentList = scanner.nextLine();
                        }
                        appService.back();
                        LOGGER.info("back to notebook");
                        break;
                    }
                    break;

                default:
                    System.out.print("Bad command, try again\n");
                    LOGGER.info("Bad command");
                    break;

            }
            // сделали какие-то операции над notebook-ом, заново выводим всё
            appService.printAll();
            System.out.print("> ");
            command = scanner.nextLine();
        }
        // exit
        System.out.println("Saving notebook...");
        appService.saveAll();
        LOGGER.info("Exit");

        LOGGER.info("App execution completed\n");
    }

}
