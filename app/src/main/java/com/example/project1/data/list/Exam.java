package com.example.project1.data.list;

import com.example.project1.data.Class;

import java.util.Date;

public class Exam extends ListItem {
    String location;

    public Exam(String name, Date due, Class associatedClass, String location) {
        super(name, due, associatedClass);
        this.location = location;
    }
}
