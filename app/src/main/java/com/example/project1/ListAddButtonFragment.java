package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ListAddButtonFragment extends Fragment {
    Button button_toDo;


    public ListAddButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_list_add_button);

//        button_toDo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void OnClick(View view) {
//                Intent i = new Intent();
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_list_add_button, container, false);
        View view = inflater.inflate(R.layout.fragment_list_add_button, container, false);

        Button todoButton = view.findViewById(R.id.btn_add_todo);
        Button assignmentButton = view.findViewById(R.id.btn_add_assignments);
        Button examButton = view.findViewById(R.id.btn_add_exams);

        todoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupFragment(new AddTodoFragment());
            }
        });

        assignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupFragment(new AddAssignmentFragment());
            }
        });

        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupFragment(new AddExamFragment());
            }
        });

        return view;
    }

    private void openPopupFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}