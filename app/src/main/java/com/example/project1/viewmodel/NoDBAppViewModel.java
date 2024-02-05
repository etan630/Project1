package com.example.project1.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.project1.data.Course;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * An implementation of the view model which simply stores data in memory.
 * <p>
 * Assigns ID's sequentially using a static counter.
 */
public class NoDBAppViewModel extends AbstractAppViewModel {
    private static int numUniqueCourses = 0;
    private static int numUniqueListItems = 0;

    private final MutableLiveData<List<Course>> courses = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<ListItem>> list = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<List<Course>> getCourses() {
        return courses;
    }

    public MutableLiveData<List<ListItem>> getList() {
        return list;
    }

    public NoDBAppViewModel() {
        super();

        initWithDummyData();
    }

    public void initWithDummyData() {
        Course math = new Course("math", "now", "pedro", "z", "gt"
                , "404", new ArrayList<>());
        addCourse(math);
        //addListItem(new Exam("doom",  new Date(), "math", "s", "here"));
    }

    public int addCourse(Course course) {
        addToLiveDataList(courses, course);

        int id = numUniqueCourses;

        course.setId(id);
        numUniqueCourses++;

        return id;
    }

    public void removeCourse(Course course) {
        removeFromLiveDataList(courses, course);
    }

    @Override
    public Course getCourseById(int id) {
        return courses.getValue().stream()
                .filter(course -> course.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean replaceCourseById(int id, Course course) {
        List<Course> courseList = this.courses.getValue();
        int index = IntStream.range(0, courseList.size())
                .filter(i -> courseList.get(i).getId() == id)
                .findAny()
                .orElse(-1);

        if (index == -1) {
            return false;
        } else {
            course.setId(id);
            setInLiveDataList(this.courses, course, index);
            return true;
        }
    }

    public int addListItem(ListItem listItem) {
        addToLiveDataList(list, listItem);

        int id = numUniqueListItems;

        listItem.setId(id);
        numUniqueListItems++;

        return id;
    }

    public void removeListItem(ListItem listItem) {
        removeFromLiveDataList(list, listItem);
    }

    @Override
    public ListItem getListItemById(int id) {
        return list.getValue().stream()
                .filter(listItem -> listItem.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean replaceListItemById(int id, ListItem listItem) {
        List<Course> courseList = this.courses.getValue();
        int index = IntStream.range(0, courseList.size())
                .filter(i -> courseList.get(i).getId() == id)
                .findAny()
                .orElse(-1);

        if (index == -1) {
            return false;
        } else {
            listItem.setId(id);
            setInLiveDataList(this.list, listItem, index);
            return true;
        }
    }

    private <T> void addToLiveDataList(MutableLiveData<List<T>> liveData, T toAdd) {
        List<T> list = liveData.getValue() == null ? new ArrayList<>() : liveData.getValue();

        list.add(toAdd);

        liveData.setValue(list);
    }

    private <T> void setInLiveDataList(MutableLiveData<List<T>> liveData, T toSet, int index) {
        List<T> list = liveData.getValue() == null ? new ArrayList<>() : liveData.getValue();

        list.set(index, toSet);

        liveData.setValue(list);
    }

    private <T> void removeFromLiveDataList(MutableLiveData<List<T>> liveData, T toRemove) {
        List<T> list = liveData.getValue() == null ? new ArrayList<>() : liveData.getValue();

        list.remove(toRemove);

        liveData.setValue(list);
    }
}
