package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.SaveService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class SaveJson implements SaveService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_NAME = "to-do.json";

    @Override
    public void saveAll(List<ToDoList> notebook) throws Exception {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(FILE_NAME), notebook);
    }

    @Override
    public List<ToDoList> loadAll() throws Exception {
        return objectMapper.readValue(new FileReader(FILE_NAME), new TypeReference<List<ToDoList>>(){});
    }

}
