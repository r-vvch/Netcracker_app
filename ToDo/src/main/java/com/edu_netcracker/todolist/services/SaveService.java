package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;

public interface SaveService {
    /**
     * Записывает существующий список задач в файл
     * @param toDoList - существующий список задач
     * @throws Exception - исключение
     */
    void writeToDoList(ToDoList toDoList) throws Exception;

    /**
     * Читает список задач из файла и формирует ToDoList
     * @throws Exception - исключение
     */
    ToDoList readToDoList() throws Exception;


}
