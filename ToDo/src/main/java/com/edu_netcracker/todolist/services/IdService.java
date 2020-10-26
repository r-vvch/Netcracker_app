package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import org.springframework.stereotype.Service;

@Service
public interface IdService {
    /**
     * Задаёт id Task'а
     * @param task - Task, которому задаётся id
     */
    void setTaskId(Task task);

    /**
     * Задаёт id ToDoList'а
     * @param toDoList - ToDoList, которому задаётся id
     */
    void setListId(ToDoList toDoList);

}
