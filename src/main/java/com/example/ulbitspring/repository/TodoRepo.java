package com.example.ulbitspring.repository;

import com.example.ulbitspring.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Long> {
}
