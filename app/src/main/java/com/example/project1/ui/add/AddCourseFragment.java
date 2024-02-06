package com.example.project1.ui.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.example.project1.R;
import com.example.project1.data.Course;
import com.example.project1.data.CourseListAdapter;

import java.util.ArrayList;

public class AddCourseFragment extends AbstractAddFragment {
    private int targetCourseId;

    private EditText classNameInput;
    private EditText timeInput;
    private EditText instructorInput;
    private EditText sectionInput;
    private EditText buildingInput;
    private EditText roomInput;
    private EditText dayOfWeekInput;
    private CourseListAdapter courseListAdapter;

    @Override
    protected int getFormContent() {
        return R.layout.add_course_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        classNameInput = view.findViewById(R.id.class_name_input);
        timeInput = view.findViewById(R.id.time_input);
        instructorInput = view.findViewById(R.id.instructor_input);
        sectionInput = view.findViewById(R.id.section_input);
        buildingInput = view.findViewById(R.id.building_input);
        roomInput = view.findViewById(R.id.room_input);
        dayOfWeekInput = view.findViewById(R.id.day_of_week_input);

        this.targetCourseId = AddCourseFragmentArgs.fromBundle(getArguments()).getCourseId();

        if (targetCourseId != -1) {
            Course course = viewModel.getCourseById(targetCourseId);

            classNameInput.setText(course.getName());
            timeInput.setText(course.getTime());
            instructorInput.setText(course.getInstructor());
            sectionInput.setText(course.getSection());
            buildingInput.setText(course.getLocation());
            roomInput.setText(course.getRoomNumber());
            dayOfWeekInput.setText(course.getDays());
        }
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return button -> {
            Course newCourse = new Course(
                    classNameInput.getText().toString(),
                    timeInput.getText().toString(),
                    instructorInput.getText().toString(),
                    sectionInput.getText().toString(),
                    buildingInput.getText().toString(),
                    roomInput.getText().toString(),
                    dayOfWeekInput.getText().toString() // TODO: input for days of week
            );
            if (targetCourseId == -1) {
                viewModel.addCourse(newCourse);
            } else {
                viewModel.replaceCourseById(targetCourseId, newCourse);
            }

            navController.navigate(R.id.coursesFragment);
        };
    }
}