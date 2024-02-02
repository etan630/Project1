package com.example.project1;

public class ExamInput {
    private String name;
    private double date;
    private double time;
    private String location;

    public ExamInput(String name, double date, double time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ExamInput{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
