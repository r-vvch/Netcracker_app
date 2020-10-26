package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.IdService;
import org.springframework.stereotype.Service;

@Service
public class IdSimple implements IdService {
    private Long taskId;
    private Long listId;

    public IdSimple() {
        taskId = 0L;
        listId = 0L;
    }

    @Override
    public void setTaskId(Task task) {
        taskId += 1;
        task.setId(taskId);
    }

    @Override
    public void setListId(ToDoList toDoList) {
        listId -= 1;
        toDoList.setId(listId);
    }
}
