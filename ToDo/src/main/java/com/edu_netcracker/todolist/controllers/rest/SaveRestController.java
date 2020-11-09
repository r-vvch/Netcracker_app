// можно удалить (?)

package com.edu_netcracker.todolist.controllers.rest;

import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.SaveService;
import com.edu_netcracker.todolist.services.impl.SaveJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaveRestController {
    static final Logger LOGGER = LoggerFactory.getLogger(SaveRestController.class);

    private SaveService saveService;

    public SaveRestController(@Qualifier("save-json") SaveService saveService) {
        this.saveService = saveService;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void write(@RequestParam List<ToDoList> toDoLists) throws Exception {
        saveService.writeToDoList(toDoLists);
        LOGGER.info("to-do list saved");
    }

    @RequestMapping(value = "load", method = RequestMethod.POST)
    public void read() throws Exception {
        saveService.readToDoList();
        LOGGER.info("to-do list loaded");
    }
}
