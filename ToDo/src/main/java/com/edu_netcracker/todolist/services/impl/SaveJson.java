package com.edu_netcracker.todolist.services.impl;

import com.edu_netcracker.todolist.entities.ToDoList;
import com.edu_netcracker.todolist.services.SaveService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

@Service("save-json")
public class SaveJson implements SaveService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_NAME = "to-do.json";

    @Override
    public void writeToDoList(List<ToDoList> toDoLists) throws Exception {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(FILE_NAME), toDoLists);
    }

    @Override
    public List<ToDoList> readToDoList() throws Exception {
        return objectMapper.readValue(new FileReader(FILE_NAME), List.class);
    }

}
