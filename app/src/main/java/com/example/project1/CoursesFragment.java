package com.example.project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project1.data.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoursesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoursesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private EditText class_name_input;
    private EditText instructor_input;
    private EditText time_input;
    private ListView class_list;
    private ArrayList<Course> courseList;
    private ArrayAdapter<Course> coursesAdapter;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        class_name_input = view.findViewById(R.id.class_name_input);
        instructor_input = view.findViewById(R.id.instructor_input);
        time_input = view.findViewById(R.id.time_input);
        class_list = view.findViewById(R.id.class_list);

        courses = new ArrayList<>();
        coursesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, courses);
        class_list.setAdapter(coursesAdapter);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = class_name_input.getText().toString();
                String instructor = instructor_input.getText().toString();
                String time = time_input.getText().toString();

                if (!className.isEmpty() && !instructor.isEmpty() && !time.isEmpty()) {
                    Course newCourse = new Course(className, instructor, time);
                    courses.add(newCourse);
                    coursesAdapter.notifyDataSetChanged();

                    class_name_input.setText("");
                    instructor_input.setText("");
                    time_input.setText("");
                } else {
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}