package com.example.spring; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class ControllerTarefa {

    @Autowired
    private ServiceTarefa service;

    @GetMapping("/tarefas")
    public List<Tarefa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tarefas")
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return service.save(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable int id, @RequestBody Tarefa tarefa) {
        return service.findById(id)
                .map(tarefaExistente -> {
                    tarefa.setId(tarefaExistente.getId());
                    service.save(tarefa);
                    return ResponseEntity.ok(tarefa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
