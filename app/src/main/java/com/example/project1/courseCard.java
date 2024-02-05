package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.data.CourseListAdapter;
import com.example.project1.viewmodel.AbstractAppViewModel;
import com.example.project1.viewmodel.NoDBAppViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link courseCard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class courseCard extends Fragment {

    //UI components
    EditText classNameInput;
    EditText timeInput;
    EditText instructorInput;
    EditText sectionInput;
    EditText buildingInput;
    EditText roomInput;
    private CourseListAdapter coursesAdapter;
    private AbstractAppViewModel model;

    public courseCard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_card, container, false);

        //ui components
        classNameInput = view.findViewById(R.id.class_name_input);
        timeInput = view.findViewById(R.id.time_input);
        instructorInput = view.findViewById(R.id.instructor_input);
        sectionInput = view.findViewById(R.id.section_input);
        buildingInput = view.findViewById(R.id.building_input);
        roomInput = view.findViewById(R.id.room_input);

        //set up viewModel
        model = new ViewModelProvider(getActivity()).get(NoDBAppViewModel.class);

        //observe courses Live Data and update UI
        model.getCourses().observe(getViewLifecycleOwner(), courses -> {
            if (courses != null) {
                coursesAdapter.setCourses(courses);
            }
        });
        return view;
    }
}