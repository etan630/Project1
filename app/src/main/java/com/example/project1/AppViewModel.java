package com.example.project1;

import com.example.project1.data.Course;
import com.example.project1.data.list.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * The app's view model which persists all data (courses, list items) across fragments.
 */
public class AppViewModel {
    private final List<Course> courses = new ArrayList<>();
    private final List<ListItem> list = new ArrayList<>();
}
