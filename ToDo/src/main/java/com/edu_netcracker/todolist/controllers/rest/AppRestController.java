package com.edu_netcracker.todolist.controllers.rest;

import com.edu_netcracker.todolist.entities.Task;
import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {
    static final Logger LOGGER = LoggerFactory.getLogger(AppRestController.class);

    public AppService appService;

    public AppRestController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "set-current", method = RequestMethod.POST)
    public void setCurrentList(Long listId) {
        appService.setCurrentList(listId);
    }

    @RequestMapping(value = "add-list", method = RequestMethod.POST)
    public void addList(@RequestParam String name) throws Exception {
        appService.addList(name);
    }

    @RequestMapping(value = "delete-list", method = RequestMethod.POST)
    public void deleteList(Long id) throws Exception {
        appService.deleteList(id);
    }

    @RequestMapping(value = "add-task", method = RequestMethod.POST)
    public void addTask(@RequestParam String name) {
        appService.addTask(name);
    }

    @RequestMapping(value = "delete-task", method = RequestMethod.POST)
    public void deleteTask(@RequestParam Long id) {
        appService.deleteTask(id);
    }

    @RequestMapping(value = "set-task-done", method = RequestMethod.POST)
    public void setTaskDone(@RequestParam Long id) {
        appService.setTaskDone(id);
    }

    @RequestMapping(value = "set-task-undone", method = RequestMethod.POST)
    public void setTaskUndone(@RequestParam Long id) {
        appService.setTaskUndone(id);
    }

    @RequestMapping(value = "get-all-lists", method = RequestMethod.POST)
    public void getAllLists() throws Exception {
        appService.getAllLists();
    }

    @RequestMapping(value = "save-list", method = RequestMethod.POST)
    public void saveList() throws Exception {
        appService.saveList();
    }
}
