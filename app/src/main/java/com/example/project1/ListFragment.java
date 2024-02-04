package com.example.project1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project1.data.list.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "output";

    Menu menu;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<ToDoInput> todoList = new ArrayList<ToDoInput>();
    List<AssignmentInput> assignmentList = new ArrayList<AssignmentInput>();
    List<ExamInput> examList = new ArrayList<ExamInput>();

    private RecyclerView recyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        fillTodoList();
        Log.d(TAG, "onCreate: " + todoList.toString());
        fillAssignmentList();
        Log.d(TAG, "onCreate: " + assignmentList.toString());
        fillExamList();
        Log.d(TAG, "onCreate: " + examList.toString());
    }

//    recyclerView = findViewById(R.id.)

    private void fillTodoList() {
        ToDoInput td1 = new ToDoInput("pick up package");
        ToDoInput td2 = new ToDoInput("do CS2340 assessment");
        ToDoInput td3 = new ToDoInput("do laundry");
        ToDoInput td4 = new ToDoInput("clean room");
        ToDoInput td5 = new ToDoInput("get groceries");

        todoList.addAll(Arrays.asList(td1, td2, td3, td4, td5));

    }
    private void fillAssignmentList() {
        AssignmentInput a1 = new AssignmentInput("CS2340", "Project 1", 2.6);
        AssignmentInput a2 = new AssignmentInput("KOR1002", "Unit 8 Workbook", 2.8);
        AssignmentInput a3 = new AssignmentInput("CS2050", "Zybooks 4", 2.3);
        AssignmentInput a4 = new AssignmentInput("EAS1600", "Lab Assignment", 2.12);

        assignmentList.addAll(Arrays.asList(a1, a2, a3, a4));

    }

    private void fillExamList() {
        ExamInput e1 = new ExamInput("CS2050 midterm 1", 2.8, 9.30, "CULC144");
        ExamInput e2 = new ExamInput("KOR1002 midterm 1", 2.10, 12.30, "online");

        examList.addAll(Arrays.asList(e1, e2));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.sort_menu,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //switch(item.getItemId) {
            //case R.id.menu_duedate
       // }
        return super.onOptionsItemSelected(item);
    }


}