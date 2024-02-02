package com.example.project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<ToDoInput> todoList = new ArrayList<ToDoInput>();
    List<AssignmentInput> assignmentInput = new ArrayList<AssignmentInput>();
    List<ExamInput> examInput = new ArrayList<ExamInput>();

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
        fillAssignmentList();
        fillExamList();
    }

    private void fillTodoList() {
        ToDoInput td1 = new ToDoInput("pick up package");
        ToDoInput td2 = new ToDoInput("do CS2340 assessment");
        ToDoInput td3 = new ToDoInput("do laundry");
        ToDoInput td4 = new ToDoInput("clean room");
        ToDoInput td5 = new ToDoInput("get groceries");
    }

    private void fillAssignmentList() {
        AssignmentInput a1 = new AssignmentInput("CS2340", "Project 1", 2.6);
        AssignmentInput a2 = new AssignmentInput("KOR1002", "Unit 8 Workbook", 2.8);
        AssignmentInput a3 = new AssignmentInput("CS2050", "Zybooks 4", 2.3);
        AssignmentInput a4 = new AssignmentInput("EAS1600", "Lab Assignment", 2.12);
    }

    private void fillExamList() {
        ExamInput e1 = new ExamInput("CS2050 midterm 1", 2.8, 9.30, "CULC144");
        ExamInput e2 = new ExamInput("KOR1002 midterm 1", 2.10, 12.30, "online");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}