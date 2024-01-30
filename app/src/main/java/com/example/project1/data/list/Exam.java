package com.example.project1.data.list;

import com.example.project1.data.Course;

import java.util.Date;

public class Exam extends ListItem {
    String location;

    public Exam(String name, Date due, Course associatedCourse, String location) {
        super(name, due, associatedCourse);
        this.location = location;
    }
}
