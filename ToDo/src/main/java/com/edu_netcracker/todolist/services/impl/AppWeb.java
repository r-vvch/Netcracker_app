package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.AppService;
import com.edu_netcracker.todolist.services.IdService;
import com.edu_netcracker.todolist.services.SaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;


public class AppWeb implements AppService {
    static final Logger LOGGER = LoggerFactory.getLogger(AppWeb.class);

    IdService idService;
    SaveService saveService;

    AppWeb(IdService idService, @Qualifier("save-json") SaveService saveService) {
        this.idService = idService;
        this.saveService = saveService;
    }

    private List<ToDoList> toDoLists = new ArrayList<>();
    private ToDoList currentList;

    @Override
    public void setCurrentList(Long listId) {
        currentList = toDoLists.get(Math.toIntExact(listId - 1L));
    }

    @Override
    public void addList(String name) {
        ToDoList toDoList = new ToDoList(name);
        idService.setListId(toDoList);
    }

    @Override
    public void deleteList(Long id) {
        toDoLists.remove(id.intValue() - 1);
    }

    @Override
    public void addTask(String name) {
        Task task = new Task(name);
        idService.setTaskId(task);
        currentList.addTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        currentList.deleteTask(id - 1L);
    }

    @Override
    public void setTaskDone(Long id) {
        currentList.getTasks().get(id.intValue() - 1).setCompletion(true);
    }

    @Override
    public void setTaskUndone(Long id) {
        currentList.getTasks().get(id.intValue() - 1).setCompletion(false);
    }

    @Override
    public List<ToDoList> getAllLists() throws Exception {
        toDoLists = saveService.readToDoList();
        return toDoLists;
    }

    @Override
    public void saveList() throws Exception {
        saveService.writeToDoList(toDoLists);
    }
}
