package com.example.mainan;

import com.example.mainan.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTarefa extends JpaRepository<Tarefa, Integer> {
}