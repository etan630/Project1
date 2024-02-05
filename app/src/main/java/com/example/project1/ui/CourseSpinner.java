package com.example.project1.ui;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.lifecycle.MutableLiveData;

import com.example.project1.data.Course;

import java.util.List;
import java.util.Objects;

public class CourseSpinner {
    private final Spinner spinner;
    private final Course noneCourse;

    public CourseSpinner(Spinner spinner, MutableLiveData<List<Course>> courses) {
        this.spinner = spinner;

        ArrayAdapter<Course> adapter = new ArrayAdapter<>(
                spinner.getContext(),
                android.R.layout.simple_spinner_item
        );
        this.noneCourse = new Course();
        noneCourse.setName("None");
        adapter.add(noneCourse); // hacky...

        adapter.addAll(Objects.requireNonNull(courses.getValue()));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public Course getSelectedCourse() {
        Course selected = (Course) spinner.getSelectedItem();
        return selected == noneCourse ? null : selected;
    }
}
