package com.example.spring;

import com.example.spring.Tarefa;
import com.example.spring.RepositoryTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTarefa {

    @Autowired
    private RepositoryTarefa repository;

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Optional<Tarefa> findById(int id) {
        return repository.findById(id);
    }

    public Tarefa save(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}