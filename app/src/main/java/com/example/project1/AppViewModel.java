package com.example.project1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project1.data.Course;
import com.example.project1.data.list.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * The app's view model which persists all data (courses, list items) across fragments.
 */
public class AppViewModel extends ViewModel {
    private final MutableLiveData<List<Course>> courses = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<ListItem>> list = new MutableLiveData<>(new ArrayList<>());
}
