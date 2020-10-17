package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;

public interface SaveService {
    /**
     * Записывает существующий список задач в файл
     * @param toDoList - существующий список задач
     * @throws Exception
     */
    void writeToDoList(ToDoList toDoList) throws Exception;

    /**
     * Читает список задач из файла и формирует ToDoList
     * @throws Exception
     */
    ToDoList readToDoList() throws Exception;


}
