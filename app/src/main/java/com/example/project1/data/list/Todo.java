package com.example.project1.data.list;

import com.example.project1.data.Course;

import java.util.Date;

public class Todo extends ListItem {
    public Todo(String name, Course associatedCourse) {
        super(name, null, associatedCourse);
    }

    @Override
    public Date getDue() {
        return new Date(); // assume these are due today
    }
}
