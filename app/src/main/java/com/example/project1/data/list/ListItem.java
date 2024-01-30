package com.example.project1.data.list;

import com.example.project1.data.Class;

import java.util.Date;

/**
 * An item that can be displayed alongside others on a user's list of upcoming activities
 */
public abstract class ListItem {
    private String name;
    private Date due;
    private Class associatedClass;

    public ListItem(String name, Date due, Class associatedClass) {
        this.name = name;
        this.due = due;
        this.associatedClass = associatedClass;
    }

    public String getName() {
        return name;
    }

    public Date getDue() {
        return due;
    }

    public Class getAssociatedClass() {
        return associatedClass;
    }
}
