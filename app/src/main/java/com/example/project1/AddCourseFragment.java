package com.example.project1;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.project1.data.Course;
import com.example.project1.viewmodel.AppViewModel;

import java.util.ArrayList;

public class AddCourseFragment extends AbstractAddFragment {
    @Override
    protected int getFormContent() {
        return R.layout.add_course_form;
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return button -> {
            EditText classNameInput = thisFragment.findViewById(R.id.class_name_input);
            EditText timeInput = thisFragment.findViewById(R.id.time_input);
            EditText instructorInput = thisFragment.findViewById(R.id.instructor_input);
            EditText sectionInput = thisFragment.findViewById(R.id.section_input);
            EditText buildingInput = thisFragment.findViewById(R.id.building_input);
            EditText roomInput = thisFragment.findViewById(R.id.room_input);

            AppViewModel viewModel = new ViewModelProvider(this).get(AppViewModel.class);
            viewModel.addCourse(
                    new Course(
                            classNameInput.getText().toString(),
                            timeInput.getText().toString(),
                            instructorInput.getText().toString(),
                            sectionInput.getText().toString(),
                            buildingInput.getText().toString(),
                            roomInput.getText().toString(),
                            new ArrayList<>() // TODO: input for days of week
                    )
            );

            navController.navigate(R.id.coursesFragment);
        };
    }
}