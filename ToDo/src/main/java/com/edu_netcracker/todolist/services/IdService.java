package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;

public interface IdService {
    /**
     * Задаёт id Task'а
     * @param task - Task, которому задаётся id
     */
    void setTaskId(Task task);

    /**
     * Задаёт id ToDoList'а
     * @param toDoList ToDoList, которому задаётся id
     */
    void setToDoListId(ToDoList toDoList);

    /**
     * Обновляет id
     * Необходим для обновления id полсе загрузки списков задач из памяти
     * @param toDoListId последний id, заданный ToDoList-у
     * @param taskId последний id, заданный Task-у
     */
    void updateId(int toDoListId, int taskId);

}
