package com.example.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.data.Course;
import com.example.project1.data.CourseListAdapter;
import com.example.project1.viewmodel.NoDBAppViewModel;

import java.util.ArrayList;
import java.util.List;


public class CoursesFragment extends Fragment {

    //UI components
    EditText classNameInput;
    EditText timeInput;
    EditText instructorInput;
    EditText sectionInput;
    EditText buildingInput;
    EditText roomInput;
    private ArrayList<Course> courseList;
    private ArrayAdapter<Course> coursesAdapter;
    private NoDBAppViewModel model;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        return view;
    }

    public void updateCourse() {
        model = new ViewModelProvider(this).get(NoDBAppViewModel.class);
        model.getCourses().observe(getViewLifecycleOwner(), new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> courses) {
                if (courses != null) {
                    //set courses to the adapter
                    coursesAdapter = new CourseListAdapter(getActivity(), courseList);
                }
            }
        });
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize UI components
        classNameInput = view.findViewById(R.id.class_name_input);
        timeInput = view.findViewById(R.id.time_input);
        instructorInput = view.findViewById(R.id.instructor_input);
        sectionInput = view.findViewById(R.id.section_input);
        buildingInput = view.findViewById(R.id.building_input);
        roomInput = view.findViewById(R.id.room_input);

        //initialize arraylist & adapter
        courseList = new ArrayList<>();
        coursesAdapter = new CourseListAdapter(getActivity(), courseList);


        //model = new ViewModelProvider(this).get(AppViewModel.class);

        updateCourse();
    }

}