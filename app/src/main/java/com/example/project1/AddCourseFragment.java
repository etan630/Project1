package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.project1.data.Course;
import com.example.project1.viewmodel.AppViewModel;

import java.util.ArrayList;

public class AddCourseFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_course, container, false);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button backButton = view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            navController.popBackStack();
        });

        EditText classNameInput = view.findViewById(R.id.class_name_input);
        EditText timeInput = view.findViewById(R.id.time_input);
        EditText instructorInput = view.findViewById(R.id.instructor_input);
        EditText sectionInput = view.findViewById(R.id.section_input);
        EditText buildingInput = view.findViewById(R.id.building_input);
        EditText roomInput = view.findViewById(R.id.room_input);

        Button addButton = view.findViewById(R.id.btn_add);
        addButton.setOnClickListener(v -> {
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
        });

        return view;
    }
}