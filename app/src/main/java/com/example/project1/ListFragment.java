package com.example.project1;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.data.list.ListItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;

    // ... Other class members and methods

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        //recyclerView = view.findViewById(R.id.recyclerView);
       // listItemAdapter = new ListItemAdapter(/* provide your data */);
        recyclerView.setAdapter(listItemAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_due_date:
                //Handle due date filter
                listItemAdapter.filterByDueDate();
                return true;

            case R.id.menu_course:
                // Handle course filter
                listItemAdapter.filterByCourse();
                return true;

            case R.id.menu_assignments:
                // Handle assignments filter
                listItemAdapter.filterByAssignment();
                return true;

            case R.id.menu_exams:
                // Handle exams filter
                listItemAdapter.filterByExams();
                return true;

            case R.id.menu_to_do:
                // Handle to-do filter
                listItemAdapter.filterByTask();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}