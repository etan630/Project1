package com.example.project1.data.list;

import com.example.project1.data.Course;

import java.util.Date;

/**
 * An item that can be displayed alongside others on a user's list of upcoming activities
 */
public abstract class ListItem {
    private int id;

    private String name;
    private Date due;
    private Course associatedCourse;

    public ListItem(String name, Date due, Course associatedCourse) {
        this.name = name;
        this.due = due;
        this.associatedCourse = associatedCourse;
    }

    public String getName() {
        return name;
    }

    public Date getDue() {
        return due;
    }

    public Course getAssociatedCourse() {
        return associatedCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
