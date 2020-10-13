package com.edu_netcracker.todo.services;

import com.edu_netcracker.todo.entities.Task;
import com.edu_netcracker.todo.entities.ToDoList;

public class IdService {
    private Long taskId;
    private Long listId;

    public IdService() {
        taskId = 0L;
        listId = 0L;
    }

    public void setTaskId(Task task) {
        taskId += 1;
        task.setId(taskId);
    }

    public void setListId(ToDoList toDoList) {
        listId -= 1;
        toDoList.setId(listId);
    }
}
