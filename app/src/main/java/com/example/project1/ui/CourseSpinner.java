package com.example.project1.ui;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.project1.data.Course;

import java.util.List;
import java.util.Objects;

public class CourseSpinner { // most smelly class award
    private final MutableLiveData<List<Course>> courses;

    private final Spinner spinner;
    private final ArrayAdapter<Course> adapter;
    private final Course noneCourse;

    public CourseSpinner(Spinner spinner, MutableLiveData<List<Course>> courses, LifecycleOwner lifecycleOwner) {
        this.courses = courses;

        this.spinner = spinner;

        this.adapter = new ArrayAdapter<>(
                spinner.getContext(),
                android.R.layout.simple_spinner_item
        );

        this.noneCourse = new Course();
        noneCourse.setName("None");

        courses.observe(lifecycleOwner, newCourses -> updateSelections());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void updateSelections() {
        adapter.clear();

        // TODO react to changed courses
        adapter.add(noneCourse); // hacky...

        adapter.addAll(Objects.requireNonNull(courses.getValue()));
    }

    public Course getSelectedCourse() {
        Course selected = (Course) spinner.getSelectedItem();
        return selected == noneCourse ? null : selected;
    }

    public void setSelectedCourse(Course course) {
        if (course == null) {
            spinner.setSelection(0);
        } else {
            spinner.setSelection(courses.getValue().indexOf(course) + 1);
        }
    }

    public Spinner getSpinner() {
        return spinner;
    }
}
