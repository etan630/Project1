package com.example.project1.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project1.R;

import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends ArrayAdapter<Course> {
    private List<Course> courses;

    public CourseListAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
        this.courses = courses;
    }

    // Override the getView method to customize the appearance of each item in the ListView
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the current course object from the list
        Course course = courses.get(position);

        // If the convertView is null (i.e., it hasn't been created yet), inflate it from the XML layout file
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_item, parent, false);
//        }
//
//        // Find the TextViews in the course_item layout
//        TextView courseNameTextView = convertView.findViewById(R.id.course_name);
//        TextView instructorNameTextView = convertView.findViewById(R.id.instructor_name);
//        TextView timeTextView = convertView.findViewById(R.id.time_input);
//
//        // Set the text of the TextViews to the corresponding values from curr course object
//        courseNameTextView.setText(course.getName());
//        instructorNameTextView.setText(course.getInstructor());
//        timeTextView.setText(course.getTime());

        // Return the updated convertView
        return convertView;
    }

    // Add a method to update the list of courses
    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }
}