package com.example.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.data.CourseListAdapter;
import com.example.project1.viewmodel.AbstractAppViewModel;
import com.example.project1.viewmodel.NoDBAppViewModel;


public class CoursesFragment extends Fragment {
    private RecyclerView coursesRecyclerView;
    private CourseListAdapter courseAdapter;
    private AbstractAppViewModel viewModel;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(NoDBAppViewModel.class);

        coursesRecyclerView = view.findViewById(R.id.courses_recycler_view);
        courseAdapter = new CourseListAdapter(viewModel);
        coursesRecyclerView.setAdapter(courseAdapter);

        viewModel.getCourses().observe(getViewLifecycleOwner(), courseAdapter::setCourses);

        return view;
    }

}