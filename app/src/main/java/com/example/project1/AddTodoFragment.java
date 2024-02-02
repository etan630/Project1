package com.example.project1;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AddTodoFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);

        Button backButton = view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).popBackStack();
        });

        return view;
    }
}