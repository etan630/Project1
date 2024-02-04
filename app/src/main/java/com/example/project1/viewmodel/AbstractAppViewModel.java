package com.example.project1.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project1.data.Course;
import com.example.project1.data.list.ListItem;

import java.util.List;

/**
 * The app's view model which gives the UI read/write to all data (courses, list items) across
 * fragments.
 */
public abstract class AbstractAppViewModel extends ViewModel {
    public abstract MutableLiveData<List<Course>> getCourses();
    public abstract Course getCourseById(int id);
    public abstract int addCourse(Course course);
    public abstract void removeCourse(Course course);
    public abstract boolean replaceCourseById(int id, Course course);


    public abstract MutableLiveData<List<ListItem>> getList();
    public abstract ListItem getListItemById(int id);
    public abstract int addListItem(ListItem listItem);
    public abstract void removeListItem(ListItem listItem);
    public abstract boolean replaceListItemById(int id, ListItem listItem);
}
