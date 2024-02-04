package com.example.project1.ui;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.lifecycle.MutableLiveData;

import com.example.project1.data.Course;

import java.util.List;
import java.util.Objects;

public class UiUtils {
    public static void activateCoursesSpinner(Spinner spinner, MutableLiveData<List<Course>> courses) {
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(
                spinner.getContext(),
                android.R.layout.simple_spinner_item,
                Objects.requireNonNull(courses.getValue())
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}
