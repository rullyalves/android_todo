package com.example.todo.model;

import java.io.Serializable;
import java.util.Objects;

public class Todo implements Serializable {

    final String uuid;
    final String title;
    final String text;

    public Todo(String uuid, String title, String text) {
        this.uuid = uuid;
        this.title = title;
        this.text = text;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return Objects.equals(uuid, todo.uuid);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

}
