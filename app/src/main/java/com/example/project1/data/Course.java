package com.example.project1.data;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * An object representing a class entered by the user.
 */
public class Course {
    private String name, time, instructor, section;
    private String location, roomNumber;
    private List<DayOfWeek> days = new ArrayList<>();

    public Course(String name, String time, String instructor, String section, String location, String roomNumber, List<DayOfWeek> days) {
        this.name = name;
        this.time = time;
        this.instructor = instructor;
        this.section = section;
        this.location = location;
        this.roomNumber = roomNumber;
        this.days = days;
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

    public List<DayOfWeek> getDays() {
        return days;
    }
}
