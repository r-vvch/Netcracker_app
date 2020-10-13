package com.edu_netcracker.todo;

import com.edu_netcracker.todo.entities.Task;
import com.edu_netcracker.todo.entities.ToDoList;
import com.edu_netcracker.todo.services.FileService;
import com.edu_netcracker.todo.services.IdService;

public class Test {
    public static void main(String[] args) {
        IdService idService = new IdService();

        Task wakeUp = new Task("wake up");
        idService.setTaskId(wakeUp);
        Task breakfast = new Task("breakfast");
        idService.setTaskId(breakfast);
        Task work1 = new Task("work");
        idService.setTaskId(work1);
        Task lunch = new Task("lunch");
        idService.setTaskId(lunch);
        Task work2 = new Task("work");
        idService.setTaskId(work2);
        Task dinner = new Task("dinner");
        idService.setTaskId(dinner);
        Task chill = new Task("chill");
        idService.setTaskId(chill);
        Task sleep = new Task("sleep");
        idService.setTaskId(sleep);

        ToDoList toDoList = new ToDoList("usual day");
        idService.setListId(toDoList);

        toDoList.addTask(wakeUp);
        toDoList.addTask(breakfast);
        toDoList.addTask(work1);
        toDoList.addTask(lunch);
        toDoList.addTask(work2);
        toDoList.addTask(dinner);
        toDoList.addTask(chill);
        toDoList.addTask(sleep);

        toDoList.printList();
        System.out.println("\n");
        toDoList.printIdList();

        Long delId = sleep.getId();
        toDoList.deleteTask(sleep.getId() - 1);
        System.out.println("\n");
        toDoList.printIdList();

        //System.out.println("That's all, folks!");

        /*
        FileService fs = new FileService();

        ToDoList toDoList = fs.readToDoList();

        Task newTask = new Task("new task");
        toDoList.addTask(newTask);

        fs.writeToDoList(toDoList);
         */
    }
}
