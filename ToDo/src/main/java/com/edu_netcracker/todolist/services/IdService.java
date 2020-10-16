package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;

public interface IdService {
    /**
     * todo: написать нормальный JavaDoc
     */
    public void setTaskId(Task task);

    public void setListId(ToDoList toDoList);

}
