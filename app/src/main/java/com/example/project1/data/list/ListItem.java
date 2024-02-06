package com.example.project1.data.list;

import java.util.Date;

/**
 * An item that can be displayed alongside others on a user's list of upcoming activities
 */
public abstract class ListItem {
    private int id;

    private boolean complete = false;

    private String name;
    private Date due;
    private int courseId = -1; // no associated course

    public ListItem(String name, Date due, int courseId) {
        this.name = name;
        this.due = due;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public Date getDue() {
        return due;
    }

    public int getAssociatedCourseId() {
        return courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
