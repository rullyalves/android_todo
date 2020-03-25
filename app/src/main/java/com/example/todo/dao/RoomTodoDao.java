package com.example.todo.dao;

import com.example.todo.model.Todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomTodoDao implements  TodoDao {
    private final static List<Todo> todos = new ArrayList();

    @Override
    public List<Todo> findAll() {
        return Collections.unmodifiableList(todos);
    }



    @Override
    public Todo findById(String uuid) {
        Todo todo = null;
        for (Todo item : todos ) {
            if(item.getUuid().equals(uuid)){
                todo = item;
                break;
            }
        }
        return todo;
    }

    @Override
    public void save(Todo todo) {
todos.add(todo);
    }

    @Override
    public void deleteById(String uuid) {
        for (Todo item: todos) {
            if (item.getUuid().equals(uuid)){
                todos.remove(item);
                break;
            }
        }
    }

    @Override
    public void updateById(String uuid, Todo todo) {
       todos.set(todos.indexOf(todo),todo);
    }
}
