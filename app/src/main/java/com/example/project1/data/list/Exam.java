package com.example.project1.data.list;

import com.example.project1.data.Course;

import java.util.Date;

public class Exam extends ListItem {

    String location;
    String time;

    public Exam(String name, Date due, String time, int associatedCourseId, String location) {
        super(name, due, associatedCourseId);
        this.location = location;
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }
}
