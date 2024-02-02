package com.example.project1;

public class AssignmentInput {

    private String course;
    private String assignment;
    private double dueDate;

    public AssignmentInput(String course, String assignment, double dueDate) {
        this.course = course;
        this.assignment = assignment;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "AssignmentInput{" +
                "course='" + course + '\'' +
                ", assignment='" + assignment + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public double getDueDate() {
        return dueDate;
    }

    public void setDueDate(double dueDate) {
        this.dueDate = dueDate;
    }
}
