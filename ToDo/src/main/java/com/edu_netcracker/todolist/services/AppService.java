package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {

    /**
     * Устанавливает текущий список задач
     * @param listId id выбранного списка задач
     */
    void setCurrentList(Long listId);

    /**
     * Добавляет новый ToDoList
     * @param name имя добавляемого списка задач
     */
    void addList(String name);

    /**
     * Удаляет заданный по id ToDoList
     * @param id id выбранного списка задач
     */
    void deleteList(Long id);

    /**
     * Добавляет новый Task в текущий ToDoList
     * @param name имя Task'а
     */
    void addTask(String name);

    /**
     * Удаляет заданный по id Task
     * @param id id, по которому производится удаление
     */
    void deleteTask(Long id);

    /**
     * Задаёт Task'у с данным id статус выполненного
     * @param id id, по которому производятся изменения
     */
    void setTaskDone(Long id);

    /**
     * Задаёт Task'у с данным id статус невыполненного
     * @param id id, по которому производятся изменения
     */
    void setTaskUndone(Long id);

    /**
     * Возвращает все сохранённые toDoList'ы
     */
    List<ToDoList> getAllLists() throws Exception;

    /**
     * Сохраняет текущий toDoList
     * @throws Exception - исключение
     */
    void saveList() throws Exception;
}
