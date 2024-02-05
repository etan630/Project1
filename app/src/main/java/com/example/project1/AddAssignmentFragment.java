package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.example.project1.data.Course;
import com.example.project1.data.list.Assignment;
import com.example.project1.ui.CourseSpinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAssignmentFragment extends AbstractAddFragment {
    private CourseSpinner courseSpinner;
    private EditText nameInput;
    private EditText dateInput;

    private DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");

    @Override
    protected int getFormContent() {
        return R.layout.add_assignment_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.courseSpinner = new CourseSpinner(view.findViewById(R.id.class_dropdown),
                viewModel.getCourses());

        this.nameInput = view.findViewById(R.id.assignment_input);
        this.dateInput = view.findViewById(R.id.duedate_input);
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return buttonView -> {
            Course selectedCourse = courseSpinner.getSelectedCourse();
            String name = nameInput.getText().toString();
            String dateStr = dateInput.getText().toString();

            Date date = parseDate(dateStr);
            if (date == null) {
                return;
            }

            viewModel.addListItem(new Assignment(
                    name,
                    date,
                    selectedCourse
            ));

            navController.navigate(R.id.listFragment);
        };
    }


}