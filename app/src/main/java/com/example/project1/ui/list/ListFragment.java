package com.example.project1.ui.list;

import android.os.Bundle;
import android.util.Log;
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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.ListItem;
import com.example.project1.viewmodel.NoDBAppViewModel;

import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private NoDBAppViewModel viewModel;
    private List<ListItem> itemList;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(NoDBAppViewModel.class);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        recyclerView = view.findViewById(R.id.lv_list);
        listItemAdapter = new ListItemAdapter(viewModel, navController);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listItemAdapter);

        viewModel.getList().observe(getViewLifecycleOwner(), list -> {
            // Update the adapter with the new list
            listItemAdapter.setList(list);
        });
        return view;
    }

    //get rid
    private void updateList(List<ListItem> newList) {
        itemList = newList;
        for (ListItem item : itemList) {
            Log.d("ListFragment", "Item type: " + item.getClass().getSimpleName());
        }
        listItemAdapter.setList(itemList);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.sort_menu, menu);
//        return true;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }
//
//
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
}