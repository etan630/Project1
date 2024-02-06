package com.example.project1.data.list;

import java.util.Date;

public class Todo extends ListItem {
    public Todo(String name, int associatedCourseId) {
        super(name, null, associatedCourseId);
    }

    @Override
    public Date getDue() {
        return new Date(0);
    }
}
