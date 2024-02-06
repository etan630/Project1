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
import com.example.project1.data.list.Todo;
import com.example.project1.ui.CourseSpinner;

public class AddTodoFragment extends AbstractAddFragment {
    private int editId;

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
                viewModel.getCourses(), this);

        this.nameInput = view.findViewById(R.id.text_task_input);

        this.editId = AddTodoFragmentArgs.fromBundle(getArguments()).getTodoId();
        if (editId != -1) {
            Todo source = (Todo) viewModel.getListItemById(editId);

            this.courseSpinner.setSelectedCourse(viewModel.getCourseById(source.getAssociatedCourseId()));
            this.nameInput.setText(source.getName());
        }
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

            Todo newTodo = new Todo(
                    name,
                    selectedCourse.getId()
            );

            if (editId != -1) {
                viewModel.replaceListItemById(editId, newTodo);
            } else {
                viewModel.addListItem(newTodo);
            }

            Toast.makeText(requireContext(), "Task added successfully", Toast.LENGTH_SHORT).show();

            navController.navigate(R.id.listFragment);
        };
    }
}