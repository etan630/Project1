package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.example.project1.ui.UiUtils;

public class AddAssignmentFragment extends AbstractAddFragment {
    @Override
    protected int getFormContent() {
        return R.layout.add_assignment_form;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner courseSelector = view.findViewById(R.id.class_dropdown);
        UiUtils.activateCoursesSpinner(courseSelector, viewModel.getCourses());
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return buttonView -> {

        };
    }
}