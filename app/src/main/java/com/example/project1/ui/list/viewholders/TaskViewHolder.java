package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.Todo;
import com.example.project1.viewmodel.AbstractAppViewModel;

public class TaskViewHolder extends AbstractListViewHolder {
    private final TextView taskDisplay;

    public TaskViewHolder(View itemView, AbstractAppViewModel viewModel) {
        super(itemView, viewModel);

        taskDisplay = itemView.findViewById(R.id.task_display);
    }

    @Override
    public void populateView(ListItem listItem) {
        Todo todo = (Todo) listItem;

        taskDisplay.setText(todo.getName());
    }
}
