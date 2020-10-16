package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.ToDoListKeeper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonFileService implements ToDoListKeeper {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_NAME = "to-do.json";

    @Override
    public void writeToDoList(ToDoList toDoList) throws Exception {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(FILE_NAME), toDoList);
    }

    @Override
    public ToDoList readToDoList() throws Exception {
        return objectMapper.readValue(new FileReader(FILE_NAME), ToDoList.class);
    }


}
