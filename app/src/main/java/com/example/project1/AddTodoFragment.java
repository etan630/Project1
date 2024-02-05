package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

            viewModel.addListItem(new Todo(
                    name,
                    selectedCourse
            ));

            navController.navigate(R.id.listFragment);
        };
    }
}