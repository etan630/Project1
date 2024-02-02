package com.example.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.project1.data.Course;
import com.example.project1.viewmodel.AppViewModel;

import java.util.ArrayList;


public class CoursesFragment extends Fragment {

    //UI components
    private EditText class_name_input;
    private EditText instructor_input;
    private EditText time_input;
    private ListView class_list;
    private ArrayList<Course> courseList;
    private ArrayAdapter<Course> coursesAdapter;
    private AppViewModel model;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        //find UI components in layout
//        class_name_input = view.findViewById(R.id.class_name_input);
//        instructor_input = view.findViewById(R.id.instructor_input);
//        time_input = view.findViewById(R.id.time_input);
//        class_list = view.findViewById(R.id.class_list);
//
//        //initialize arraylist & adapter -- i dont think we'll actually
//        //need to initialized the arraylist bc itll exist alr??? idk
//        courseList = new ArrayList<>();
//        coursesAdapter = new CourseListAdapter(getActivity(), courseList);
//
//        class_list.setAdapter(coursesAdapter);
//
//        Button add_button; //there isn't actually an add button but...
//
//        model = new ViewModelProvider(this).get(AppViewModel.class);
//
//        // Create the observer which updates the UI.
//        final Observer<List<Course>> coursesObserver = new Observer<List<Course>>() {
//            @Override
//            public void onChanged(@Nullable final List<Course> courses) {
//                // Update the adapter with the new list of courses
//                coursesAdapter.setCourses(courses);
//            }
//        };
//
//        // get the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.getCourses().observe(getViewLifecycleOwner(), coursesObserver);
//
//        add_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get the input values from the EditTexts
//                String className = class_name_input.getText().toString();
//                String instructor = instructor_input.getText().toString();
//                String time = time_input.getText().toString();
//
//                // Check if the input values are not empty
//                if (!className.isEmpty() && !instructor.isEmpty() && !time.isEmpty()) {
//                    // Create a new Course object with the input values
//                    Course newCourse = new Course(className, instructor, time);
//
//                    // Add the new Course object to the ArrayList using the ViewModel
//                    model.addCourse(newCourse);
//
//                    // Clear the input values
//                    class_name_input.setText("");
//                    instructor_input.setText("");
//                    time_input.setText("");
//                } else {
//                    // Show a Toast message if the input values are empty
//                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return view;
    }

    /*
    public LiveData<List<Course>> getCourses() {
        return courses;
    }

    public void addCourse(Course newCourse) {
        List<Course> currentCourses = courses.getValue();
        if (currentCourses == null) {
            currentCourses = new ArrayList<>();
        }
        currentCourses.add(newCourse);
        courses.setValue(currentCourses);
    }

    ^^assuming methods like these are in the viewModel
     */

}