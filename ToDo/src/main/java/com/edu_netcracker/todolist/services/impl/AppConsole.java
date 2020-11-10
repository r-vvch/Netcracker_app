package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.AppService;
import com.edu_netcracker.todolist.services.IdService;
import com.edu_netcracker.todolist.services.SaveService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppConsole implements AppService {
    IdService idService;
    SaveService saveService;

    AppConsole(IdService idService, SaveService saveService) {
        this.idService = idService;
        this.saveService = saveService;
    }

    private List<ToDoList> notebook = new ArrayList<>();
    private ToDoList currentToDoList;

    @Override
    public void start() {
        try {
            notebook = saveService.loadAll();
            int lastToDoListId = 0;
            for (ToDoList bufferToDoList : notebook) {
                if (bufferToDoList.getId() < lastToDoListId) {
                    lastToDoListId = bufferToDoList.getId();
                }
            }
            int lastTaskId = 0;
            for (ToDoList bufferToDoList : notebook) {
                for (int i = 0; i < bufferToDoList.getTasks().size(); i++) {
                    if (bufferToDoList.getTasks().get(i).getId() > lastTaskId) {
                        lastTaskId = bufferToDoList.getTasks().get(i).getId();
                    }
                }
            }
            idService.updateId(lastToDoListId, lastTaskId);
            printAll();
        } catch (Exception e) {
            notebook = new ArrayList<>();
        }
    }

    @Override
    public void setCurrentToDoList(int id) {
        int i = 0;
        while (true) {
            if (notebook.get(i).getId() == id) {
                currentToDoList = notebook.get(i);
                break;
            }
            i++;
        }
    }

    @Override
    public void addToDoList(String name) {
        ToDoList toDoList = new ToDoList(name);
        idService.setToDoListId(toDoList);
        notebook.add(toDoList);
    }

    @Override
    public void deleteToDoList(int id) {
        int i = 0;
        while (true) {
            if (notebook.get(i).getId() == id) {
                notebook.remove(i);
                break;
            }
            i++;
        }
    }

    @Override
    public void renameToDoList(int id, String newName) {
        int i = 0;
        while (true) {
            if (notebook.get(i).getId() == id) {
                notebook.get(i).setName(newName);
                break;
            }
            i++;
        }
    }

    @Override
    public void addTask(String name) {
        Task task = new Task(name);
        idService.setTaskId(task);
        currentToDoList.addTask(task);
    }

    @Override
    public void deleteTask(int id) {
        int i = 0;
        while (true) {
            if (currentToDoList.getTasks().get(i).getId() == id) {
                currentToDoList.deleteTask(i);
                break;
            }
            i++;
        }
    }

    @Override
    public void renameTask(int id, String newName) {
        currentToDoList.renameTask(id, newName);
    }

    @Override
    public void setTaskDone(int id) {
        int i = 0;
        while (true) {
            if (currentToDoList.getTasks().get(i).getId() == id) {
                currentToDoList.getTasks().get(i).setCompletion(true);
                break;
            }
            i++;
        }
    }

    @Override
    public void setTaskUndone(int id) {
        int i = 0;
        while (true) {
            if (currentToDoList.getTasks().get(i).getId() == id) {
                currentToDoList.getTasks().get(i).setCompletion(false);
                break;
            }
            i++;
        }
    }

    @Override
    public void printToDoList(ToDoList toDoList) {
        System.out.println(toDoList.getId() + ". " + toDoList.getName() + ":");
        for (int i = 0; i < toDoList.getTasks().size(); i++) {
            System.out.println(toDoList.getTasks().get(i).getId() + ". " +
                    toDoList.getTasks().get(i).getName() + " " +
                    toDoList.getTasks().get(i).getPrettyCompletion());
        }
    }

    @Override
    public void printCurrentToDoList() {
        printToDoList(currentToDoList);
    }

    @Override
    public void printAll() {
        for (ToDoList bufferToDoList : notebook) {
            printToDoList(bufferToDoList);
        }
    }

    @Override
    public void back() {
        int i = 0;
        while (true) {
            if (currentToDoList.getId() == notebook.get(i).getId()) {
                notebook.set(i, currentToDoList);
                break;
            }
            i++;
        }
    }

    @Override
    public void saveAll() throws Exception {
        saveService.saveAll(notebook);
    }

}

