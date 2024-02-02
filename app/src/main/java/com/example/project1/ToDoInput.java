package com.example.project1;

public class ToDoInput {
    private String task;
    public ToDoInput(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "ToDoInput{" +
                "task='" + task + '\'' +
                '}';
    }

    public void setTask(String task) {
        this.task = task;
    }
}
