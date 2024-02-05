package com.example.project1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.example.project1.data.Course;
import com.example.project1.data.list.Exam;
import com.example.project1.ui.CourseSpinner;

import java.util.Date;

public class AddExamFragment extends AbstractAddFragment {
    private CourseSpinner courseSpinner;
    private EditText nameInput, dateInput, timeInput, locInput;

    @Override
    protected int getFormContent() {
        return R.layout.add_exam_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.courseSpinner = new CourseSpinner(view.findViewById(R.id.class_dropdown),
                viewModel.getCourses());

        this.nameInput = view.findViewById(R.id.exam_name_input);
        this.dateInput = view.findViewById(R.id.exam_date_input);
        this.timeInput = view.findViewById(R.id.exam_time);
        this.locInput = view.findViewById(R.id.exam_location_input);
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return buttonView -> {
            Course selectedCourse = courseSpinner.getSelectedCourse();
            String name = nameInput.getText().toString();
            String dateStr = dateInput.getText().toString();
            String time = timeInput.getText().toString();
            String location = locInput.getText().toString();

            if (selectedCourse == null || name.isEmpty() || dateStr.isEmpty() || time.isEmpty() || location.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Date date = parseDate(dateStr);
            if (date == null) {
                Toast.makeText(requireContext(), "Invalid date format", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModel.addListItem(new Exam(
                    name,
                    date,
                    time,
                    selectedCourse,
                    location
            ));

            Toast.makeText(requireContext(), "Exam added successfully", Toast.LENGTH_SHORT).show();

            Log.d("Navigation", "Navigating to ListFragment");
            navController.navigate(R.id.listFragment);
        };
    }
}