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
import com.example.project1.data.list.Assignment;
import com.example.project1.ui.CourseSpinner;

import java.util.Date;

public class AddAssignmentFragment extends AbstractAddFragment {
    private int editId;

    private CourseSpinner courseSpinner;
    private EditText nameInput;
    private EditText dateInput;

    @Override
    protected int getFormContent() {
        return R.layout.add_assignment_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.courseSpinner = new CourseSpinner(view.findViewById(R.id.class_dropdown),
                viewModel.getCourses(), this);

        this.nameInput = view.findViewById(R.id.assignment_input);
        this.dateInput = view.findViewById(R.id.duedate_input);

        this.editId = AddAssignmentFragmentArgs.fromBundle(getArguments()).getAssignmentId();
        if (editId != -1) {
            Assignment assignment = (Assignment) viewModel.getListItemById(editId);

            courseSpinner.setSelectedCourse(viewModel.getCourseById(assignment.getAssociatedCourseId()));
            nameInput.setText(assignment.getName());
            dateInput.setText(dateFormat.format(assignment.getDue()));
        }
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return buttonView -> {
            Course selectedCourse = courseSpinner.getSelectedCourse();
            String name = nameInput.getText().toString();
            String dateStr = dateInput.getText().toString();

            if (selectedCourse == null || name.isEmpty() || dateStr.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Date date = parseDate(dateStr);
            if (date == null) {
                Toast.makeText(requireContext(), "Invalid date format", Toast.LENGTH_SHORT).show();
                return;
            }

            Assignment newAssignment = new Assignment(
                    name,
                    date,
                    selectedCourse.getId()
            );

            if (editId != -1) {
                viewModel.replaceListItemById(editId, newAssignment);
            } else {
                viewModel.addListItem(newAssignment);
            }

            Toast.makeText(requireContext(), "Assignment added successfully", Toast.LENGTH_SHORT).show();

            navController.navigate(R.id.listFragment);
        };
    }


}