package com.example.project1.ui.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.example.project1.R;
import com.example.project1.data.Course;
import com.example.project1.data.list.Exam;
import com.example.project1.ui.CourseSpinner;

import java.util.Date;

public class AddExamFragment extends AbstractAddFragment {
    private int editId;

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
                viewModel.getCourses(), this);

        this.nameInput = view.findViewById(R.id.exam_name_input);
        this.dateInput = view.findViewById(R.id.exam_date_input);
        this.timeInput = view.findViewById(R.id.exam_time);
        this.locInput = view.findViewById(R.id.exam_location_input);

        this.editId = AddExamFragmentArgs.fromBundle(getArguments()).getExamId();
        if (editId != -1) {
            Exam source = (Exam) viewModel.getListItemById(editId);

            this.courseSpinner.setSelectedCourse(viewModel.getCourseById(source.getAssociatedCourseId()));
            this.nameInput.setText(source.getName());
            this.dateInput.setText(dateFormat.format(source.getDue()));
            this.timeInput.setText(source.getTime());
            this.locInput.setText(source.getLocation());
        }
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

            Exam newExam = new Exam(
                    name,
                    date,
                    time,
                    selectedCourse.getId(),
                    location
            );

            if (editId != -1) {
                viewModel.replaceListItemById(editId, newExam);
            } else {
                viewModel.addListItem(newExam);
            }

            Toast.makeText(requireContext(), "Exam added successfully", Toast.LENGTH_SHORT).show();

            navController.navigate(R.id.listFragment);
        };
    }
}