package com.example.project1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
    Button btn_back;


    public ListAddButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_add_button);

        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ListAddButtonFragment.this, ToDoAddFragment.class);
                startActivity(intent);
            }
        });

        //button_toDo.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void OnClick(View view) {
                //Intent i = new Intent();
            //}
        //});
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
                openPopupFragment(new ToDoAddFragment());
            }
        });

        assignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopupFragment(new AssigmentsAddFragment());
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