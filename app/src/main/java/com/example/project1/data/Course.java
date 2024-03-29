package com.example.project1.data;

import androidx.annotation.NonNull;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * An object representing a class entered by the user.
 */
public class Course {
    private int id = -1; // not assigned until done so by backend

    private String name, time, instructor, section;
    private String location, roomNumber;
    private String days;

    public Course() {}

    public Course(String name, String time, String instructor, String section, String location, String roomNumber, String days) {
        this.name = name;
        this.time = time;
        this.instructor = instructor;
        this.section = section;
        this.location = location;
        this.roomNumber = roomNumber;
        this.days = days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getSection() {
        return section;
    }

    public String getLocation() {
        return location;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDays() {
        return days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
