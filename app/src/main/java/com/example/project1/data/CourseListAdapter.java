package com.example.project1.data;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.R;
import com.example.project1.viewmodel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends ArrayAdapter<Course> {
    private List<Course> courses;
    private Context context;


    public CourseListAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
        this.courses = courses;
        this.context = context;
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

        //click listeners for delete
        Button deleteButton = convertView.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(v -> showDeleteConfirmation(course));

        // Return the updated convertView
        return convertView;
    }

    // Add a method to update the list of courses
    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    private void showDeleteConfirmation(Course course) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete Course");
        builder.setMessage("Are you sure you want to delete this course " + course.getName() + "?");
        builder.setPositiveButton("Yes", (dialog, which) -> deleteCourse(course));
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void deleteCourse(Course course) {
        courses.remove(course);
        AppViewModel viewModel = new ViewModelProvider((FragmentActivity) context).get(AppViewModel.class);
        viewModel.removeCourse(course);
    }
}