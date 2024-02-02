package com.example.project1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListAddButtonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListAddButtonFragment extends Fragment {
    Button button_toDo;


    public ListAddButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_add_button);

        button_toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View view) {
                Intent i = new Intent()
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_add_button, container, false);
    }
}