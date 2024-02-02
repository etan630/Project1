package com.example.project1.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project1.data.Course;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The app's view model which persists all data (courses, list items) across fragments.
 */
public class AppViewModel extends ViewModel {
    private final MutableLiveData<List<Course>> courses = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<ListItem>> list = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<List<Course>> getCourses() {
        return courses;
    }

    public MutableLiveData<List<ListItem>> getList() {
        return list;
    }

    public void initWithDummyData() {
        Course math = new Course("math", "now", "pedro", "z", "gt"
                , "404", new ArrayList<>());
        addCourse(math);
        addListItem(new Exam("doom", new Date(), math, "here"));
    }

    public void addCourse(Course course) {
        addToLiveDataList(courses, course);
    }

    public void removeCourse(Course course) {
        removeFromLiveDataList(courses, course);
    }

    public void addListItem(ListItem listItem) {
        addToLiveDataList(list, listItem);
    }

    public void removeListItem(ListItem listItem) {
        removeFromLiveDataList(list, listItem);
    }

    private <T> void addToLiveDataList(MutableLiveData<List<T>> liveData, T toAdd) {
        List<T> list = liveData.getValue() == null ? new ArrayList<>() : liveData.getValue();

        list.add(toAdd);

        liveData.setValue(list);
    }

    private <T> void removeFromLiveDataList(MutableLiveData<List<T>> liveData, T toRemove) {
        List<T> list = liveData.getValue() == null ? new ArrayList<>() : liveData.getValue();

        list.remove(toRemove);

        liveData.setValue(list);
    }
}
