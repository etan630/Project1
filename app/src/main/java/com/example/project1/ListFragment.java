package com.example.project1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.data.CourseListAdapter;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.ListItemAdapter;
import com.example.project1.viewmodel.AbstractAppViewModel;
import com.example.project1.viewmodel.NoDBAppViewModel;

import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private AbstractAppViewModel viewModel;

    private List<ListItem> itemList;

    public ListFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        viewModel = new ViewModelProvider(this).get(NoDBAppViewModel.class);

        recyclerView = view.findViewById(R.id.lv_list);
        listItemAdapter = new ListItemAdapter(viewModel); // Initialize the adapter
        recyclerView.setAdapter(listItemAdapter);

        viewModel.getList().observe(getViewLifecycleOwner(), this::updateList);

        return view;
    }

    private void updateList(List<ListItem> newList) {
        itemList = newList;
        listItemAdapter.setList(itemList);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    //Menu menu;

    // ... Other class members and methods

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_list, container, false);
//
//
//        recyclerView = view.findViewById(R.id.recyclerView);
//        listItemAdapter = new ListItemAdapter(/* provide your data */);
//        recyclerView.setAdapter(listItemAdapter);
//
//        return view;
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflator();
//        inflater.inflate(R.menu.sort_menu, menu);
//
//        return true;
//    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_due_date:
//                // Handle due date filter
//                listItemAdapter.filterByDueDate();
//                return true;
//
//            case R.id.menu_course:
//                // Handle course filter
//                listItemAdapter.filterByCourse();
//                return true;
//
//            case R.id.menu_assignments:
//                // Handle assignments filter
//                listItemAdapter.filterByAssignment();
//                return true;
//
//            case R.id.menu_exams:
//                // Handle exams filter
//                listItemAdapter.filterByExams();
//                return true;
//
//            case R.id.menu_to_do:
//                // Handle to-do filter
//                listItemAdapter.filterByTask();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//        return true;
//    }
//}