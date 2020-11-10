package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.IdService;

public class IdSimple implements IdService {
    private int taskId;
    private int toDoListId;

    public IdSimple() {
        taskId = 0;
        toDoListId = 0;
    }

    @Override
    public void setTaskId(Task task) {
        taskId += 1;
        task.setId(taskId);
    }

    @Override
    public void setToDoListId(ToDoList toDoList) {
        toDoListId -= 1;
        toDoList.setId(toDoListId);
    }

    @Override
    public void updateId(int listId, int taskId) {
        this.toDoListId = listId;
        this.taskId = taskId;
    }
}
