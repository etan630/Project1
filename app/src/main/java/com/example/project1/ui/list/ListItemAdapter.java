package com.example.project1.ui.list;// ListAdapter.java

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.Assignment;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.Todo;
import com.example.project1.viewmodel.AbstractAppViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private static final int VIEW_TYPE_3 = 3;

    private List<ListItem> itemList;
    private List<ListItem> filteredList;
    private AbstractAppViewModel viewModel;

    public ListItemAdapter(AbstractAppViewModel viewModel) {
        this.viewModel = viewModel;
        this.filteredList = new ArrayList<>();
    }

    public void setList(List<ListItem> items) {
        if (items != null) {
            Log.d("ListItemAdapter", "Received list: " + items.toString());

            this.itemList = new ArrayList<>(items);
            this.filteredList = new ArrayList<>(items);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList == null || itemList.isEmpty()) {
            return super.getItemViewType(position);
        }

        ListItem item = itemList.get(position);
        if (item instanceof Exam) {
            return VIEW_TYPE_1;
        } else if (item instanceof Todo) {
            return VIEW_TYPE_2;
        } else {
            return VIEW_TYPE_3;
        }
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_1:
                View v_exam = inflater.inflate(R.layout.fragment_exam, parent, false);
                viewHolder = new ExamViewHolder(v_exam);
                break;

            case VIEW_TYPE_2:
                View v_task = inflater.inflate(R.layout.fragment_task, parent, false);
                viewHolder = new TaskViewHolder(v_task);
                break;

            case VIEW_TYPE_3:
                View v_assign = inflater.inflate(R.layout.fragment_assignment, parent, false);
                viewHolder = new AssignmentViewHolder(v_assign);
                break;

            default:
                throw new IllegalArgumentException("Invalid view type");
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListItem item = itemList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_1:
                ((ExamViewHolder) holder).bindExam((Exam) item);
                break;

            case VIEW_TYPE_2:
                ((TaskViewHolder) holder).bindTask((Todo) item);
                break;

            case VIEW_TYPE_3:
                ((AssignmentViewHolder) holder).bindAssignment((Assignment) item);
                break;

            default:
                throw new IllegalArgumentException("Invalid view type");
        }
        Log.d("ListItemAdapter", "Bound item at position " + position + ": " + item.toString());
    }

//    public void filterByCourse(String courseName) {
//        filteredList.clear();
//
//        for (ListItem item : itemList) {
//            if (item instanceof Assignment || item instanceof Exam) {
//                Course associatedCourse = item.getAssociatedClass();
//                if (associatedCourse != null && associatedCourse.getName().equalsIgnoreCase(courseName)) {
//                    filteredList.add(item);
//                }
//            }
//        }
//
//        notifyDataSetChanged();
//    }
//
//    public void filterByAssignment() {
//        filteredList.clear();
//
//        for (ListItem item : itemList) {
//            if (item instanceof Assignment) {
//                filteredList.add(item);
//            }
//        }
//
//        notifyDataSetChanged();
//    }
//
//    public void filterByTask() {
//        filteredList.clear();
//
//        for (ListItem item : itemList) {
//            if (item instanceof Todo) {
//                filteredList.add(item);
//            }
//        }
//
//        notifyDataSetChanged();
//    }
//
//    public void filterByExams() {
//        filteredList.clear();
//
//        for (ListItem item : itemList) {
//            if (item instanceof Exam) {
//                filteredList.add(item);
//            }
//        }
//
//        notifyDataSetChanged();
//    }
//
//
//    public void filterByDueDate(Date dueDate) {
//        filteredList.clear();
//
//        for (ListItem item : itemList) {
//            if (item instanceof Assignment && ((Assignment) item).getDue().equals(dueDate)) {
//                filteredList.add(item);
//            }
//        }
//
//        notifyDataSetChanged();
//    }
}
