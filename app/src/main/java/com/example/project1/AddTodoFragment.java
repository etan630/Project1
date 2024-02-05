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
import com.example.project1.data.list.Todo;
import com.example.project1.ui.CourseSpinner;

public class AddTodoFragment extends AbstractAddFragment {
    private CourseSpinner courseSpinner;
    private EditText nameInput;

    @Override
    protected int getFormContent() {
        return R.layout.add_todo_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.courseSpinner = new CourseSpinner(view.findViewById(R.id.class_dropdown),
                viewModel.getCourses());

        this.nameInput = view.findViewById(R.id.text_task_input);
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return buttonView -> {
            Course selectedCourse = courseSpinner.getSelectedCourse();
            String name = nameInput.getText().toString();

            if (selectedCourse == null || name.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            viewModel.addListItem(new Todo(
                    name,
                    selectedCourse
            ));

            Toast.makeText(requireContext(), "Task added successfully", Toast.LENGTH_SHORT).show();

            Log.d("Navigation", "Navigating to ListFragment");

            navController.navigate(R.id.listFragment);
        };
    }
}