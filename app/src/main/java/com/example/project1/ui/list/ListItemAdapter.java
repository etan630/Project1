package com.example.project1.ui.list;// ListAdapter.java

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.Todo;
import com.example.project1.ui.list.viewholders.AbstractListViewHolder;
import com.example.project1.ui.list.viewholders.AssignmentViewHolder;
import com.example.project1.ui.list.viewholders.ExamViewHolder;
import com.example.project1.ui.list.viewholders.TaskViewHolder;
import com.example.project1.viewmodel.AbstractAppViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final AbstractAppViewModel viewModel;
    private final NavController navController;


    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private static final int VIEW_TYPE_3 = 3;

    private List<ListItem> itemList;

    public ListItemAdapter(AbstractAppViewModel viewModel, NavController navController) {
        this.viewModel = viewModel;
        this.navController = navController;
    }

    public void setList(List<ListItem> items) {
        if (items != null) {
            Log.d("ListItemAdapter", "Received list: " + items.toString());

            this.itemList = new ArrayList<>(items);
            itemList.sort(((o1, o2) -> {
                if (o1.getDue().equals(o2.getDue())) {
                    return 0;
                } else if (o1.getDue().before(o2.getDue())) {
                    return -1;
                } else {
                    return 1;
                }
            }));

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
        AbstractListViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_1:
                View v_exam = inflater.inflate(R.layout.list_exam, parent, false);
                viewHolder = new ExamViewHolder(v_exam, viewModel, navController);
                break;

            case VIEW_TYPE_2:
                View v_task = inflater.inflate(R.layout.list_task, parent, false);
                viewHolder = new TaskViewHolder(v_task, viewModel, navController);
                break;

            case VIEW_TYPE_3:
                View v_assign = inflater.inflate(R.layout.list_assignment, parent, false);
                viewHolder = new AssignmentViewHolder(v_assign, viewModel, navController);
                break;

            default:
                throw new IllegalArgumentException("Invalid view type");
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AbstractListViewHolder listViewHolder = (AbstractListViewHolder) holder;

        ListItem item = itemList.get(position);

        listViewHolder.bindTo(item);
    }
}
