package com.example.project1.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.Course;
import com.example.project1.data.list.Assignment;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.Todo;
import com.example.project1.ui.CourseSpinner;
import com.example.project1.viewmodel.NoDBAppViewModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private NoDBAppViewModel viewModel;
    private List<ListItem> itemList;

    // filter values
    private boolean removeCompleted = false;
    private Course filterCourse;
    private Class<? extends ListItem> filterType;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(NoDBAppViewModel.class);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        Spinner completeSpinner = view.findViewById(R.id.completefilterspinner);
        ArrayAdapter<String> completeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        completeAdapter.addAll(Arrays.asList("All", "Incomplete"));
        completeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        completeSpinner.setAdapter(completeAdapter);
        completeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    removeCompleted = false;
                } else {
                    removeCompleted = true;
                }
                updateFilteredList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                throw new RuntimeException("what");
            }
        });

        CourseSpinner courseSpinner = new CourseSpinner(view.findViewById(R.id.coursefilterspinner), viewModel.getCourses(), this);
        courseSpinner.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterCourse = courseSpinner.getSelectedCourse();
                updateFilteredList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                throw new RuntimeException("what");
            }
        });

        Spinner typeSpinner = view.findViewById(R.id.typefilterspinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        typeAdapter.addAll(Arrays.asList("None", "Assignment", "Exam", "Todo"));
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    default:
                    case 0:
                        filterType = null;
                        break;
                    case 1:
                        filterType = Assignment.class;
                        break;
                    case 2:
                        filterType = Exam.class;
                        break;
                    case 3:
                        filterType = Todo.class;
                        break;
                }

                updateFilteredList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                throw new RuntimeException("what");
            }
        });

        recyclerView = view.findViewById(R.id.lv_list);
        listItemAdapter = new ListItemAdapter(viewModel, navController);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listItemAdapter);

        viewModel.getList().observe(getViewLifecycleOwner(), list -> {
            this.itemList = list;
            updateFilteredList();
        });

        return view;
    }

    private void updateFilteredList() {
        List<ListItem> filtered = itemList.stream()
                .filter((item) -> {
                    if (removeCompleted) {
                        return !item.isComplete();
                    } else {
                        return true;
                    }
                })
                .filter((item) -> {
                    if (filterCourse != null) {
                        return item.getAssociatedCourseId() == filterCourse.getId();
                    } else {
                        return true;
                    }
                })
                .filter((item) -> {
                    if (filterType != null) {
                        return filterType.isInstance(item);
                    } else {
                        return true;
                    }
                })
                .collect(Collectors.toList());

        listItemAdapter.setList(filtered);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}