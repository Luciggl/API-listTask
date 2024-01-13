package com.Luciggl.Lista.de.tarefaas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class ListaDeTarefasController {

    private ArrayList<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ListaDeTarefasController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public ResponseEntity<String> listTasks() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping()
    public ResponseEntity<String> createTasks(@RequestBody String task) {
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<String> clearTasks(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}
