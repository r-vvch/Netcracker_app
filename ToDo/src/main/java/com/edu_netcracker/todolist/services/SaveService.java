package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;
import java.util.List;

public interface SaveService {
    /**
     * Записывает существующие списки задач в файл
     * @param notebook все списки задач
     * @throws Exception исключение
     */
    void saveAll(List<ToDoList> notebook) throws Exception;

    /**
     * Загружает списки задач из файла
     * @throws Exception исключение
     */
    List<ToDoList> loadAll() throws Exception;

}
