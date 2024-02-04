package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class AddTodoFragment extends AbstractAddFragment {
    @Override
    protected int getFormContent() {
        return R.layout.add_todo_form;
    }

    @Override
    protected View.OnClickListener onAdd(View thisFragment, NavController navController) {
        return null;
    }
}