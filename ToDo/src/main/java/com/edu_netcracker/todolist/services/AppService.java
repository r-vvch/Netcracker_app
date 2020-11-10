package com.edu_netcracker.todolist.services;

import com.edu_netcracker.todolist.entities.ToDoList;
import org.springframework.stereotype.Service;

@Service
public interface AppService {
    /**
     * Начинает работу с приложением
     * Выводит весь Notebook - все существующие списки задач
     * Предлагает выбор - создать новый список задач или выбрать существующий
     * Соответственно, на данном этапе создаёт список задач или загружает сохранённый
     * @throws Exception - исключение
     */
    void start() throws Exception;

    /**
     * Устанавливает текущий список задач
     * @param id id выбранного списка задач
     */
    void setCurrentToDoList(int id);

    /**
     * Добавляет ToDoList
     * @param name имя ToDoList-а
     */
    void addToDoList(String name);

    /**
     * Удаляет ToDoList
     * @param id id, по которому производится удаление
     */
    void deleteToDoList(int id);

    /**
     * Добавляет Task
     * @param name имя Task-а
     */
    void addTask(String name);

    /**
     * Удаляет заданный по id Task
     * @param id id, по которому производится удаление
     */
    void deleteTask(int id);

    /**
     * Задаёт Task'у с данным id статус выполненного
     * @param id id, по которому производятся изменения
     */
    void setTaskDone(int id);

    /**
     * Задаёт Task'у с данным id статус невыполненного
     * @param id - id, по которому производятся изменения
     */
    void setTaskUndone(int id);

    /**
     * Печатает переданный в аргументе ToDoList
     * @param toDoList печатаемый список задач
     */
    void printToDoList(ToDoList toDoList);

    /**
     * Печатает текущий ToDoList
     */
    void printCurrentToDoList();

    /**
     * Печатает все ToDoList-ы
     */
    void printAll();

    /**
     * Возвращается из currentToDoList
     */
    void back();

    /**
     * Сохраняет все ToDoList-ы в файл
     * @throws Exception исключение
     */
    void saveAll() throws Exception;

}
