package com.example.todo.dao;

import com.example.todo.model.Todo;

import java.util.List;

public interface TodoDao {

    List<Todo> findAll();

    Todo findById(String uuid);

    void save(Todo todo);

    void deleteById(String uuid);

    void updateById(String uuid,Todo todo);

}
