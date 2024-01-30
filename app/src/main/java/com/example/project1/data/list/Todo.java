package com.example.project1.data.list;

import com.example.project1.data.Class;

import java.util.Date;

public class Todo extends ListItem {
    public Todo(String name, Class associatedClass) {
        super(name, null, associatedClass);
    }

    @Override
    public Date getDue() {
        return new Date(); // assume these are due today
    }
}
