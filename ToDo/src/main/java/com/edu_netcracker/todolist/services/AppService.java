package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;

public interface AppService {
    /**
     * Начинает работу с приложением
     * Предлагает выбор - создать новый лист или загрузить из памяти
     * Соответственно, на данном этапе создаёт лист или загружает сохранённый
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * Добавляет Task
     * @param name - имя Task'а
     */
    void addTask(String name);

    /**
     * Удаляет заданный по id Task
     * @param id - id, по которому производится удаление
     */
    void deleteTask(Long id);

    /**
     * Задаёт Task'у с данным id статус выполненного
     * @param id - id, по которому производятся изменения
     */
    void setTaskDone(Long id);

    /**
     * Задаёт Task'у с данным id статус невыполненного
     * @param id - id, по которому производятся изменения
     */
    void setTaskUndone(Long id);

    /**
     * Печатает текущий toDoList
     */
    void printList();

    /**
     * Сохраняет текущий toDoList
     * @throws Exception
     */
    void saveList() throws Exception;
}
