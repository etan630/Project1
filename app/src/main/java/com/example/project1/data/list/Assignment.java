package com.example.project1.data.list;

import com.example.project1.data.Course;

import java.util.Date;

public class Assignment extends ListItem {
    public Assignment(String name, Date due, Course associatedCourse) {
        super(name, due, associatedCourse);
    }
}
