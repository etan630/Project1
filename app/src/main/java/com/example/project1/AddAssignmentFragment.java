package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

public class AddAssignmentFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_assignment, container, false);

        Button backButton = view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).popBackStack();
        });

        return view;
    }
}