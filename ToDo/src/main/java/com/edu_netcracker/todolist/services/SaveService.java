package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaveService {
    /**
     * Записывает существующие списки задач в файл
     * @param toDoLists - существующий массив списков задач
     * @throws Exception - исключение
     */
    void writeToDoList(List<ToDoList> toDoLists) throws Exception;

    /**
     * Читает списки задач из файла и формирует ToDoList'ы
     * @throws Exception - исключение
     */
    List<ToDoList> readToDoList() throws Exception;


}
